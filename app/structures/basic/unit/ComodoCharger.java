package structures.basic.unit;

import structures.basic.*;

public class ComodoCharger extends Unit {

    public ComodoCharger() {
        this.attack = 1;
        this.health = 3;
        this.intialHealth = 3;
    }

    public ComodoCharger(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 1;
        this.health = 3;
        this.intialHealth = 3;
    }

    public ComodoCharger(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 1;
        this.health = 3;
        this.intialHealth = 3;
    }

    public ComodoCharger(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 1;
        this.health = 3;
        this.intialHealth = 3;
    }

}
