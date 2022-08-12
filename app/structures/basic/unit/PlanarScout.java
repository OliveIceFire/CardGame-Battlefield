package structures.basic.unit;

import structures.basic.*;

public class PlanarScout extends Unit {

    public PlanarScout() {
        this.attack = 2;
        this.health = 1;
        this.intialHealth = 1;
    }

    public PlanarScout(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 2;
        this.health = 1;
        this.intialHealth = 1;
    }

    public PlanarScout(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 2;
        this.health = 1;
        this.intialHealth = 1;
    }

    public PlanarScout(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 2;
        this.health = 1;
        this.intialHealth = 1;
    }

}
