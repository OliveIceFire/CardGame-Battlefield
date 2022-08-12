package structures.basic.unit;

import structures.basic.*;

public class Windshrike extends Unit {

    public Windshrike() {
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

    public Windshrike(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

    public Windshrike(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

    public Windshrike(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

    public void setMovableTile(Tile[][] tiles, int tilex, int tiley) {
        for(int i=0; i< 9; i++) {
            for(int j=0; j< 5; j++) {
                Tile tile = tiles[i][j];
                if(tile.getUnit() == null) {
                    tile.setMovable(true);
                }
            }
        }
    }
}
