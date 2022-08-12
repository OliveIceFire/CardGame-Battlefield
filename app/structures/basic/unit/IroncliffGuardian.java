package structures.basic.unit;

import structures.basic.*;

public class IroncliffGuardian extends Unit {

    public IroncliffGuardian() {
        this.attack = 3;
        this.health = 10;
        this.intialHealth = 10;
    }

    public IroncliffGuardian(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 3;
        this.health = 10;
        this.intialHealth = 10;
    }

    public IroncliffGuardian(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 3;
        this.health = 10;
        this.intialHealth = 10;
    }

    public IroncliffGuardian(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 3;
        this.health = 10;
        this.intialHealth = 10;
    }

}
