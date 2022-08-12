package structures.basic.unit;

import structures.basic.*;

public class HailstoneGolem extends Unit {

    public HailstoneGolem() {
        this.attack = 4;
        this.health = 6;
        this.intialHealth = 6;
    }

    public HailstoneGolem(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 4;
        this.health = 6;
        this.intialHealth = 6;
    }

    public HailstoneGolem(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 4;
        this.health = 6;
        this.intialHealth = 6;
    }

    public HailstoneGolem(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 4;
        this.health = 6;
        this.intialHealth = 6;
    }

}
