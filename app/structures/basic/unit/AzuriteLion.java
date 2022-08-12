package structures.basic.unit;

import structures.basic.*;

public class AzuriteLion extends Unit {

    private boolean firstAttack = true;

    public AzuriteLion() {
        this.attack = 2;
        this.health = 10;
        this.intialHealth = 10;
    }

    public AzuriteLion(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 2;
        this.health = 10;
        this.intialHealth = 10;
    }

    public AzuriteLion(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 2;
        this.health = 10;
        this.intialHealth = 10;
    }

    public AzuriteLion(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 2;
        this.health = 10;
        this.intialHealth = 10;
    }

    public boolean isFirstAttack() {
        return firstAttack;
    }

    public void setFirstAttack(boolean firstAttack) {
        this.firstAttack = firstAttack;
    }
}
