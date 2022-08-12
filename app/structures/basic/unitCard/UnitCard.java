package structures.basic.unitCard;

import structures.basic.*;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

import java.util.ArrayList;

public class UnitCard extends Card {
    protected int attack;
    protected int health;
    protected Unit unit;
    protected static int id = 2;
    protected EffectAnimation effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_summon);

    public UnitCard(){}

    public UnitCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public EffectAnimation getEffectAnimation() {
        return this.effectAnimation;
    }

    public void setEffectAnimation(EffectAnimation effectAnimation) {
        this.effectAnimation = effectAnimation;
    }

    public void setSummonableTile(Tile[][] tiles, ArrayList<Unit> units) {
        int tilex,tiley;
        for(Unit unit: units) {
            if(unit.isFriendlyUnit()) {
                tilex = unit.getPosition().getTilex();
                tiley = unit.getPosition().getTiley();
                if(tilex + 1 <= 8) {
                    if(tiles[tilex + 1][tiley].getUnit() == null) {
                        tiles[tilex + 1][tiley].setSummonable(true);
                    }
                    if(tiley + 1 <= 4) {
                        if(tiles[tilex + 1][tiley + 1].getUnit() == null) {
                            tiles[tilex + 1][tiley + 1].setSummonable(true);
                        }
                    }
                }
                if(tilex - 1 >= 0) {
                    if(tiles[tilex - 1][tiley].getUnit() == null) {
                        tiles[tilex - 1][tiley].setSummonable(true);
                    }
                    if(tiley - 1 >= 0) {
                        if(tiles[tilex - 1][tiley - 1].getUnit() == null) {
                            tiles[tilex - 1][tiley - 1].setSummonable(true);
                        }
                    }
                }
                if(tiley + 1 <= 4) {
                    if(tiles[tilex][tiley + 1].getUnit() == null) {
                        tiles[tilex][tiley + 1].setSummonable(true);
                    }
                    if(tilex - 1 >= 0) {
                        if(tiles[tilex - 1][tiley + 1].getUnit() == null) {
                            tiles[tilex - 1][tiley + 1].setSummonable(true);
                        }
                    }
                }
                if(tiley - 1 >= 0) {
                    if(tiles[tilex][tiley - 1].getUnit() == null) {
                        tiles[tilex][tiley - 1].setSummonable(true);
                    }
                    if(tilex + 1 <= 8) {
                        if(tiles[tilex + 1][tiley - 1].getUnit() == null) {
                            tiles[tilex + 1][tiley - 1].setSummonable(true);
                        }
                    }
                }
            }
        }
    }

}
