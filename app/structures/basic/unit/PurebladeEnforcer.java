package structures.basic.unit;

import structures.basic.*;

public class PurebladeEnforcer extends Unit {

    public PurebladeEnforcer() {
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public PurebladeEnforcer(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public PurebladeEnforcer(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public PurebladeEnforcer(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public void spellThief() {
        this.attack++;
        this.health++;
    }

}
