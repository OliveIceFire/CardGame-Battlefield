package structures.basic.unit;

import structures.GameState;
import structures.basic.*;

public class BlazeHound extends Unit {

    public BlazeHound() {
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

    public BlazeHound(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

    public BlazeHound(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

    public BlazeHound(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 4;
        this.health = 3;
        this.intialHealth = 3;
    }

}
