package events;


import com.fasterxml.jackson.databind.JsonNode;

import akka.actor.ActorRef;
import commands.BasicCommands;
import structures.GameState;
import structures.basic.PlayerCommend;
import structures.basic.Tile;
import structures.basic.Unit;
import structures.basic.spellCard.SpellCard;
import structures.basic.unitCard.UnitCard;


/**
 * Indicates that the user has clicked an object on the game canvas, in this case a tile.
 * The event returns the x (horizontal) and y (vertical) indices of the tile that was
 * clicked. Tile indices start at 1.
 * 
 * { 
 *   messageType = “tileClicked”
 *   tilex = <x index of the tile>
 *   tiley = <y index of the tile>
 * }
 * 
 * @author Dr. Richard McCreadie
 *
 */
public class TileClicked implements EventProcessor{

	@Override
	public void processEvent(ActorRef out, GameState gameState, JsonNode message) {

		int tilex = message.get("tilex").asInt();
		int tiley = message.get("tiley").asInt();

		PlayerCommend.clearCardHighlight(out, gameState);
		
		if (gameState.something) {
			Tile tile = gameState.tiles[tilex][tiley];
			Unit unit = gameState.findUnit(tilex,tiley);


			boolean logic1, logic2, logic3, logic4, logic5, logic6, logic7, logic8, logic9, logic10, logic11, logic12, logic13;

			logic1 = unit == null;
			logic2 = gameState.selectedUnit == null;
			logic3 = gameState.selectedCard == null;
			logic4 = tile.isMovable();
			logic5 = tile.isAttackable();
			logic9 = tile.isSummonable();
			logic10 = tile.isCastable();
			logic11 = gameState.selectedTile == null;

			if(logic3) {
				if(!logic1) {
					logic6 = unit.isFriendlyUnit();
					logic12 = unit.isMovable();
					logic13 = unit.isAttackable();
					if(logic6) {
						PlayerCommend.clearCardHighlight(out, gameState);
						PlayerCommend.clearTile(out, gameState);
						gameState.clearSelected();
						gameState.selectedUnit = unit;
						gameState.selectedTile = tile;
						if(logic12 && logic13) {
							PlayerCommend.highlightMovableTile(out, gameState, tilex, tiley);
							PlayerCommend.highlightAttackableTile(out, gameState, tilex, tiley);
						} else if(logic12) {
							PlayerCommend.highlightMovableTile(out, gameState, tilex, tiley);
						} else if(logic13) {
							PlayerCommend.highlightAttackableTile(out, gameState, tilex, tiley);
						}
					} else {
						if(!logic2) {
							gameState.targetUnit = unit;
							if(logic5) {
								//attackAction
								PlayerCommend.clearCardHighlight(out, gameState);
								PlayerCommend.clearTile(out, gameState);
								PlayerCommend.attackAction(out, gameState, gameState.selectedTile, tile, true);
								gameState.clearSelected();
							} else {
								PlayerCommend.clearCardHighlight(out, gameState);
								PlayerCommend.clearTile(out, gameState);
								gameState.clearSelected();
							}
						} else {
							PlayerCommend.clearCardHighlight(out, gameState);
							PlayerCommend.clearTile(out, gameState);
							gameState.clearSelected();
						}
					}
				} else {
					if(!logic2) {
						if(logic4) {
							// moveAction
							PlayerCommend.clearCardHighlight(out, gameState);
							PlayerCommend.clearTile(out, gameState);
							PlayerCommend.MoveAction(out, gameState, gameState.selectedUnit, tile);
							gameState.clearSelected();
						} else  {
							PlayerCommend.clearCardHighlight(out, gameState);
							PlayerCommend.clearTile(out, gameState);
							gameState.clearSelected();
						}
					} else {
						PlayerCommend.clearCardHighlight(out, gameState);
						PlayerCommend.clearTile(out, gameState);
						gameState.clearSelected();
					}
				}
			} else {
				logic7 = gameState.selectedCard instanceof UnitCard;
				logic8 = gameState.selectedCard instanceof SpellCard;

				if(logic7 && logic9) {
					PlayerCommend.clearTile(out, gameState);
					PlayerCommend.playerSummonUnit(out, gameState, tile);
					PlayerCommend.clearCardHighlight(out, gameState);
					gameState.clearSelected();
				} else if(logic8 && logic10) {
					PlayerCommend.clearTile(out, gameState);
					PlayerCommend.playerCastSpell(out, gameState, tile);
					PlayerCommend.clearCardHighlight(out, gameState);
					gameState.clearSelected();

				} else {
					PlayerCommend.clearCardHighlight(out, gameState);
					PlayerCommend.clearTile(out, gameState);
					gameState.clearSelected();
				}
			}
		}
	}

}
