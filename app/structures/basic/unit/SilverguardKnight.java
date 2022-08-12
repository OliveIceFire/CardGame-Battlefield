package structures.basic.unit;

import structures.basic.*;

public class SilverguardKnight extends Unit {

    public SilverguardKnight() {
        this.attack = 1;
        this.health = 5;
        this.intialHealth = 5;
    }

    public SilverguardKnight(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 1;
        this.health = 5;
        this.intialHealth = 5;
    }

    public SilverguardKnight(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 1;
        this.health = 5;
        this.intialHealth = 5;
    }

    public SilverguardKnight(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 1;
        this.health = 5;
        this.intialHealth = 5;
    }

    public void avatarDamagedEffect() {
        this.attack = this.attack + 2;
    }

}
