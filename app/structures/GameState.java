package structures;

import akka.actor.ActorRef;
import commands.BasicCommands;
import structures.basic.*;
import structures.basic.unit.*;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

import java.util.ArrayList;

/**
 * This class can be used to hold information about the on-going game.
 * Its created with the GameActor.
 * 
 * @author Dr. Richard McCreadie
 *
 */
public class GameState {

	
	public boolean gameInitalised = false;

	public boolean something = false;

	public static int turnRound;

	public static Player humanPlayer;
	public static Player aiPlayer;

	public static CardDeck playerDeck;
	public static PlayerHand playerHand;

	public static ArrayList<Unit> unitsOnBoard;
	public static Tile[][] tiles;

	public static Card selectedCard;
	public static Unit selectedUnit;
	public static Unit targetUnit;
	public static Tile selectedTile;
	// method for game initalisation
	public void initalisation(ActorRef out) {
		BasicCommands.addPlayer1Notification(out, "game start", 3);
		this.turnRound = 1;
		this.playerDeck = new CardDeck();
		this.playerHand = new PlayerHand();
		this.humanPlayer = new Player(20, 0);
		this.aiPlayer = new Player(20, 0);
		this.unitsOnBoard = new ArrayList<>();
		this.tiles = new Tile[9][5];
		drawTile(out);
		drawAvatar(out);
		BasicCommands.setPlayer1Health(out, humanPlayer);
		BasicCommands.setPlayer2Health(out, aiPlayer);
		PlayerCommend.setPlayer1Mana(out, this,turnRound + 1);
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		while(this.playerHand.getHandPosition()<3) {
			PlayerCommend.drawCard(out, this);
			try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

	public void aiEndTurn(ActorRef out) {
		setPlayer2Mana(out, aiPlayer,0);
		BasicCommands.addPlayer1Notification(out, "my turn", 1);
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void aiStartTurn(ActorRef out) {
		BasicCommands.addPlayer1Notification(out, "your turn", 1);
		setPlayer2Mana(out, aiPlayer,turnRound + 1);
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void drawTile(ActorRef out) {
		for(int i=0; i< 9; i++) {
			for(int j=0; j< 5; j++) {
				Tile tile = BasicObjectBuilders.loadTile(i, j);
				this.tiles[i][j] = tile;
				BasicCommands.drawTile(out, tile, 0);
				try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
	}

	public void drawAvatar(ActorRef out) {
		Tile tile0 = this.tiles[1][2];
		Unit humanAvatar = BasicObjectBuilders.loadUnit(StaticConfFiles.humanAvatar, 0, HumanAvatar.class);
		drawUnit(out, humanAvatar, tile0);
		Tile tile1 = this.tiles[7][2];
		Unit aiAvatar = BasicObjectBuilders.loadUnit(StaticConfFiles.aiAvatar, 1, AiAvatar.class);
		aiAvatar.setFriendlyUnit(false);
		drawUnit(out, aiAvatar, tile1);
	}

	public void setUnitAttack(ActorRef out, Unit unit, int attack) {
		BasicCommands.setUnitAttack(out, unit, attack);
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void setUnitHealth(ActorRef out, Unit unit, int health) {
		BasicCommands.setUnitHealth(out, unit, health);
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
	}

	public void setPlayer2Mana(ActorRef out, Player player, int mana) {
		if(mana < 10) {
			player.setMana(mana);
		} else {
			player.setMana(9);
		}
		BasicCommands.setPlayer2Mana(out, player);
	}
	// method for drawing a unit on the board
	public void drawUnit(ActorRef out, Unit unit, Tile tile) {
		unit.setPositionByTile(tile);
		BasicCommands.drawUnit(out, unit, tile);
		BasicCommands.playEffectAnimation(out, unit.getEffectAnimation(), tile);
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		setUnitAttack(out, unit, unit.getAttack());
		setUnitHealth(out, unit, unit.getHealth());
		unitsOnBoard.add(unit);
		tile.setUnit(unit);
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
	}

	public Unit findUnit(int tilex, int tiley) {
		return this.tiles[tilex][tiley].getUnit();
	}

	public void clearSelected() {
		this.selectedCard = null;
		this.selectedUnit = null;
		this.targetUnit = null;
		this.selectedTile = null;
	}

	public void checkWinorLose(ActorRef out) {
		if(humanPlayer.getHealth() < 1) {
			BasicCommands.addPlayer1Notification(out, "Human player lose the game! Game over!", 5);
			this.something = false;
		} else if(aiPlayer.getHealth() < 1) {
			BasicCommands.addPlayer1Notification(out, "AI player lose the game and you win! Game over!", 5);
			this.something = false;
		}
	}

}
