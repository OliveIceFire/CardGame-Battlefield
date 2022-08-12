package structures.basic.unit;

import structures.basic.*;

public class HumanAvatar extends Unit {

    public HumanAvatar() {
        this.attack = 2;
        this.health = 20;
        this.intialHealth = 20;
    }

    public HumanAvatar(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 2;
        this.health = 20;
        this.intialHealth = 20;
    }

    public HumanAvatar(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 2;
        this.health = 20;
        this.intialHealth = 20;
    }

    public HumanAvatar(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 2;
        this.health = 20;
        this.intialHealth = 20;
    }

}
