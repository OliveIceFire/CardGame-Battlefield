package structures.basic;

import akka.actor.ActorRef;
import commands.BasicCommands;
import structures.GameState;
import structures.basic.spellCard.SpellCard;
import structures.basic.unit.*;
import structures.basic.unitCard.UnitCard;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class AiPlayerCommend {
    // method for changing AI player's health
    public static void setPlayer2Health(ActorRef out, GameState gameState, int health) {
        GameState.aiPlayer.setHealth(health);
        BasicCommands.setPlayer2Health(out, GameState.aiPlayer);
        gameState.checkWinorLose(out);
    }
    // method for changing AI player's mana
    public static void setPlayer2Mana(ActorRef out, GameState gameState, int mana) {
        if(mana < 10) {
            GameState.aiPlayer.setMana(mana);
        } else {
            GameState.aiPlayer.setMana(9);
        }
        BasicCommands.setPlayer2Mana(out, GameState.aiPlayer);
    }
    // method for setting unit's attack value
    public static void setUnitAttack(ActorRef out, Unit unit, int attack) {
        BasicCommands.setUnitAttack(out, unit, attack);
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
    }
    // method for setting unit's health value
    public static void setUnitHealth(ActorRef out, Unit unit, int health) {
        BasicCommands.setUnitHealth(out, unit, health);
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
    }
    // method for drawing a card from human player's deck
    public static void drawCard(ActorRef out, GameState gameState) {
        Card topCard;
        if(GameState.playerDeck.getPlayerDeck().size() > 0) {
            if((GameState.playerHand.getHandPosition() <= GameState.playerHand.getMaxPosition())) {
                topCard = GameState.playerDeck.drawPlayerCard();
                gameState.playerHand.addCard(topCard);
                topCard.setHandPosition(gameState.playerHand.getHandPosition());
                BasicCommands.drawCard(out, topCard, gameState.playerHand.getHandPosition(), 0);
            } else {
                topCard = gameState.playerDeck.drawPlayerCard();
                BasicCommands.drawCard(out, topCard, 0, 0);
                BasicCommands.addPlayer1Notification(out, "delete card", 1);
                try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
                BasicCommands.deleteCard(out, 0);
            }
        }
    }
    // method for deleting a card from human player's hand card
    public static void deleteHandCard(ActorRef out, GameState gameState, int position) {
        for(int i=position; i <= gameState.playerHand.getPlayerCards().length; i++) {
            BasicCommands.deleteCard(out, i);
            try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }
    // method for deleting a unit from the board
    public static void deleteUnit(ActorRef out, GameState gameState,Unit unit, Tile tile) {
        BasicCommands.deleteUnit(out, unit);
        BasicCommands.playUnitAnimation(out, unit, UnitAnimationType.death);
        gameState.unitsOnBoard.remove(unit);
        tile.setUnit(null);
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
    }
    // method for changing tiles color where a unit can move to
    public static void highlightMovableTile(ActorRef out, GameState gameState,int tilex, int tiley) {
        if(gameState.selectedUnit.isMovable()) {
            gameState.selectedUnit.setMovableTile(gameState.tiles, tilex, tiley);
            for(int i=0; i< 9; i++) {
                for(int j=0; j< 5; j++) {
                    Tile tile = gameState.tiles[i][j];
                    if(tile.isMovable()) {
                        BasicCommands.drawTile(out, tile, 1);
                        try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
                    }
                }
            }
        }
    }
    // method for changing tiles color where a unit can be summoned
    public static void highlightSummonableTile(ActorRef out, GameState gameState) {
        if(gameState.humanPlayer.getMana() >= gameState.selectedCard.getManacost()) {
            gameState.selectedCard.setSummonableTile(gameState.tiles,gameState.unitsOnBoard);
            for(int i=0; i< 9; i++) {
                for(int j=0; j< 5; j++) {
                    Tile tile = gameState.tiles[i][j];
                    if(tile.isSummonable()) {
                        BasicCommands.drawTile(out, tile, 1);
                        try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
                    }
                }
            }
        }
    }
    // method for changing tiles color where a spell can cast
    public static void highlightCastableTile(ActorRef out, GameState gameState) {
        if(gameState.humanPlayer.getMana() >= gameState.selectedCard.getManacost()) {
            gameState.selectedCard.setCastableTile(gameState.tiles,gameState.unitsOnBoard);
            for(int i=0; i< 9; i++) {
                for(int j=0; j< 5; j++) {
                    Tile tile = gameState.tiles[i][j];
                    if(tile.isCastable()) {
                        BasicCommands.drawTile(out, tile, 2);
                        try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
                    }
                }
            }
        }
    }
    // method for changing tiles color where a unit can attack to
    public static void highlightAttackableTile(ActorRef out, GameState gameState,int tilex, int tiley) {
        if(gameState.selectedUnit.isAttackable()) {
            gameState.selectedUnit.setAttackableTile(gameState.tiles, tilex, tiley);
            gameState.selectedUnit.setMoveAndAttackable(gameState.tiles);
            for(int i=0; i< 9; i++) {
                for(int j=0; j< 5; j++) {
                    Tile tile = gameState.tiles[i][j];
                    if(tile.isAttackable()) {
                        BasicCommands.drawTile(out, tile, 2);
                        try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
                    }
                }
            }
        }
    }
    // method for clearing all tile boolean status
    public static void clearTile(ActorRef out, GameState gameState) {
        for(int i=0; i< 9; i++) {
            for(int j=0; j< 5; j++) {
                if(gameState.tiles[i][j].isMovable() || gameState.tiles[i][j].isAttackable() || gameState.tiles[i][j].isSummonable() || gameState.tiles[i][j].isCastable()) {
                    BasicCommands.drawTile(out, gameState.tiles[i][j], 0);
                    gameState.tiles[i][j].setMovable(false);
                    gameState.tiles[i][j].setAttackable(false);
                    gameState.tiles[i][j].setSummonable(false);
                    gameState.tiles[i][j].setCastable(false);
                    try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
                }
            }
        }
    }
    // method for clear hand card highlight
    public static void clearCardHighlight(ActorRef out, GameState gameState) {
        for(int i=0; i < gameState.playerHand.getPlayerCards().length; i++) {
            if(gameState.playerHand.getPlayerCards()[i] != null) {
                BasicCommands.drawCard(out, gameState.playerHand.getPlayerCards()[i], i+1, 0);
            }
            try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }
    // method for human player to summon a unit on the board
    public static void playerSummonUnit(ActorRef out, GameState gameState,Tile tile) {
        Unit unit = ((UnitCard) gameState.selectedCard).getUnit();
        deleteHandCard(out, gameState,gameState.selectedCard.getHandPosition());
        gameState.playerHand.removeCard(gameState.selectedCard.getHandPosition());
        gameState.drawUnit(out, unit, tile);
        summonEffect(out, gameState, unit);
        unit.setFriendlyUnit(true);
        setPlayer2Mana(out, gameState, gameState.humanPlayer.getMana() - gameState.selectedCard.getManacost());
    }
    // method for human player to cast a spell
    public static void playerCastSpell(ActorRef out, GameState gameState, Tile tile) {
        SpellCard spellCard = ((SpellCard) gameState.selectedCard);
        deleteHandCard(out, gameState,gameState.selectedCard.getHandPosition());
        BasicCommands.deleteCard(out, gameState.selectedCard.getHandPosition()+1);
        gameState.playerHand.removeCard(gameState.selectedCard.getHandPosition());
        EffectAnimation ef = spellCard.getEffectAnimation();
        spellCard.castSpell(tile.getUnit());
        spellEffect(out, gameState);
        BasicCommands.playEffectAnimation(out, ef, tile);
        setPlayer2Mana(out, gameState, gameState.humanPlayer.getMana() - gameState.selectedCard.getManacost());
        try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
        checkUnitStats(out, gameState, tile.getUnit(), tile);
    }
    // method for activating a unit effect when the unit be summoned
    public static void summonEffect(ActorRef out, GameState gameState, Unit unit) {
        if(unit instanceof AzureHerald) {
            ((AzureHerald) unit).summonedEffect(gameState.unitsOnBoard.get(0));
            checkUnitStats(out, gameState ,gameState.unitsOnBoard.get(0),gameState.tiles[gameState.unitsOnBoard.get(0).getPosition().getTilex()][gameState.unitsOnBoard.get(0).getPosition().getTiley()]);
            BasicCommands.addPlayer1Notification(out, "Azure Herald summoned effect: human avatar health+3", 2);
        } else if(unit instanceof BlazeHound){
            drawCard(out, gameState);
            BasicCommands.addPlayer1Notification(out, "Blaze Hound summoned effect: both players draw a card", 2);
        }
    }
    // method for activating a unit effect when casting a spell
    public static void spellEffect(ActorRef out, GameState gameState) {
        for(Unit unit: gameState.unitsOnBoard) {
            if(unit instanceof PurebladeEnforcer) {
                ((PurebladeEnforcer) unit).spellThief();
                checkUnitStats(out, gameState, unit, gameState.tiles[unit.getPosition().getTilex()][unit.getPosition().getTiley()]);
                BasicCommands.addPlayer1Notification(out, "Spell effect: Pureblade Enforcer attack+1/health+1", 2);
            }
        }
    }
    // method for activating a unit effect when the unit is death
    public static void deathEffect(ActorRef out, GameState gameState,Unit unit) {
        if(unit instanceof Windshrike) {
            drawCard(out, gameState);
            BasicCommands.addPlayer1Notification(out, "Windshrike death effect: owner player draw a card", 2);
        }
    }
    // method for activating a unit effect when the human avatar damaged
    public static void avatarDamagedEffect(ActorRef out, GameState gameState) {
        for(Unit unit: gameState.unitsOnBoard) {
            if(unit instanceof SilverguardKnight) {
                ((SilverguardKnight) unit).avatarDamagedEffect();
                BasicCommands.addPlayer1Notification(out, "Avatar damaged effect: Silverguard Knight attack+2", 2);
                checkUnitStats(out, gameState, unit, gameState.tiles[unit.getPosition().getTilex()][unit.getPosition().getTiley()]);
            }
        }
    }
    // method for units to move to a highlight tile
    public static void MoveAction(ActorRef out, GameState gameState, Unit unit, Tile tile){
        Tile originalTile = gameState.tiles[unit.getPosition().getTilex()][unit.getPosition().getTiley()];
        originalTile.setUnit(null);
        BasicCommands.moveUnitToTile(out, unit, tile);
        BasicCommands.playUnitAnimation(out, unit, UnitAnimationType.move);
        unit.setPositionByTile(tile);
        tile.setUnit(unit);
        unit.setMovable(false);
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
        BasicCommands.playUnitAnimation(out, unit, UnitAnimationType.idle);
    }
    // method for units to attack to a enemy unit
    public static void attackAction(ActorRef out , GameState gameState,Tile selectedTile, Tile targetTile, boolean inTurn){
        Unit selectedUnit = selectedTile.getUnit();
        Unit targetUnit = targetTile.getUnit();
        Tile MoveTargetTile;
        int disX = Math.abs(targetTile.getTilex()-selectedTile.getTilex());
        int disY = Math.abs(targetTile.getTiley()-selectedTile.getTiley());
        int distance = Math.max(disX, disY);
        if(selectedUnit.isRanged() && inTurn) {
            rangeAttack(out, gameState, selectedTile, targetTile);
        } else {
            if(distance>1&&inTurn) {
                MoveTargetTile = targetUnit.getBestAttackPoint();

                MoveAction(out, gameState, selectedUnit, MoveTargetTile);
                selectedTile = MoveTargetTile;
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            }

            BasicCommands.playUnitAnimation(out, selectedUnit, UnitAnimationType.attack);
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            BasicCommands.playUnitAnimation(out, selectedUnit, UnitAnimationType.idle);
            targetUnit.setHealth(targetUnit.getHealth()-selectedUnit.getAttack());
            checkUnitStats(out, gameState, targetUnit, targetTile);
            if (inTurn && targetUnit.getHealth() > 0){// needs to be within the attackRange.
                // How to calculate the distance of two Tiles.
                attackAction(out, gameState, targetTile, selectedTile, false);
            }
        }

        if(selectedUnit instanceof AzuriteLion) {
            if(((AzuriteLion) selectedUnit).isFirstAttack()) {
                ((AzuriteLion) selectedUnit).setFirstAttack(false);
                selectedUnit.setAttackable(true);
            } else {
                selectedUnit.setAttackable(false);
                selectedUnit.setMovable(false);
            }
            if(((AzuriteLion) selectedUnit).isMovable()) {
                selectedUnit.setMovable(true);
            } else {
                selectedUnit.setMovable(false);
            }
        } else {
            selectedUnit.setAttackable(false);
            selectedUnit.setMovable(false);
        }

    }
    // method for units to attack ranged to a enemy unit
    public static void rangeAttack(ActorRef out ,GameState gameState, Tile selectedTile, Tile targetTile) {
        Unit selectedUnit = selectedTile.getUnit();
        Unit targetUnit = targetTile.getUnit();
        EffectAnimation projectile = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_projectiles);
        BasicCommands.playUnitAnimation(out, selectedUnit, UnitAnimationType.attack);
        BasicCommands.playProjectileAnimation(out, projectile, 0, selectedTile, targetTile);
        try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        BasicCommands.playUnitAnimation(out, selectedUnit, UnitAnimationType.idle);
        targetUnit.setHealth(targetUnit.getHealth()-selectedUnit.getAttack());
        checkUnitStats(out, gameState, targetUnit, targetTile);
    }
    // method for checking a unit's health and attack if it has been changed
    public static void checkUnitStats(ActorRef out, GameState gameState, Unit unit, Tile tile) {
        if(unit.getHealth() > 0) {
            setUnitHealth(out, unit, unit.getHealth());
            setUnitAttack(out, unit, unit.getAttack());
        } else {
            setUnitHealth(out,  unit, 0);
            BasicCommands.playUnitAnimation(out, unit, UnitAnimationType.death);
            try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
            deleteUnit(out, gameState,unit, tile);
            deathEffect(out, gameState, unit);
        }

        if(unit instanceof HumanAvatar) {
            if(gameState.humanPlayer.getHealth() > unit.getHealth()) {
                avatarDamagedEffect(out, gameState);
            }
            PlayerCommend.setPlayer1Health(out, gameState, unit.getHealth());
        } else if(unit instanceof AiAvatar) {
            setPlayer2Health(out, gameState, unit.getHealth());
        }
    }
    // method for unit reset status after end turn
    public static void resetUnitStatus(GameState gameState) {
        for(Unit unit: gameState.unitsOnBoard) {
            if(unit.isFriendlyUnit()) {
                unit.setAttackable(true);
                unit.setMovable(true);
            }
            if(unit instanceof AzuriteLion) {
                unit.setAttackable(true);
                unit.setMovable(true);
                ((AzuriteLion) unit).setFirstAttack(true);
            }
        }
    }
}
