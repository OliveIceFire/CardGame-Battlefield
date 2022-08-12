package structures.basic.unit;

import structures.basic.*;

public class Serpenti extends Unit {

    public Serpenti() {
        this.attack = 7;
        this.health = 4;
        this.intialHealth = 4;
    }

    public Serpenti(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 7;
        this.health = 4;
        this.intialHealth = 4;
    }

    public Serpenti(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 7;
        this.health = 4;
        this.intialHealth = 4;
    }

    public Serpenti(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 7;
        this.health = 4;
        this.intialHealth = 4;
    }
}
