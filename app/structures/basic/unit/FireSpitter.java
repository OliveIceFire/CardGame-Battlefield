package structures.basic.unit;

import structures.basic.*;

public class FireSpitter extends Unit {

    public FireSpitter() {
        this.attack = 3;
        this.health = 2;
        this.intialHealth = 2;
        this.ranged = true;
    }

    public FireSpitter(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 3;
        this.health = 2;
        this.intialHealth = 2;
        this.ranged = true;
    }

    public FireSpitter(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 3;
        this.health = 2;
        this.intialHealth = 2;
        this.ranged = true;
    }

    public FireSpitter(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 3;
        this.health = 2;
        this.intialHealth = 2;
        this.ranged = true;
    }

    public void setAttackableTile(Tile[][] tiles, int tilex, int tiley) {
        for(int i=0; i< 9; i++) {
            for(int j=0; j< 5; j++) {
                if(tiles[i][j].getUnit() != null && !tiles[i][j].getUnit().isFriendlyUnit()) {
                    tiles[i][j].setAttackable(true);
                }
            }
        }
    }

}
