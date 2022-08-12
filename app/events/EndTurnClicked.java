package events;

import com.fasterxml.jackson.databind.JsonNode;

import akka.actor.ActorRef;
import structures.GameState;
import structures.basic.PlayerCommend;

/**
 * Indicates that the user has clicked an object on the game canvas, in this case
 * the end-turn button.
 * 
 * { 
 *   messageType = “endTurnClicked”
 * }
 * 
 * @author Dr. Richard McCreadie
 *
 */
public class EndTurnClicked implements EventProcessor{

	@Override
	public void processEvent(ActorRef out, GameState gameState, JsonNode message) {
		PlayerCommend.clearCardHighlight(out, gameState);
		PlayerCommend.clearTile(out, gameState);
		gameState.clearSelected();
		PlayerCommend.resetUnitStatus(gameState);

		PlayerCommend.player1EndTurn(out,gameState);
		gameState.aiStartTurn(out);









		gameState.aiEndTurn(out);
		PlayerCommend.player1StartTurn(out, gameState);
	}

}
