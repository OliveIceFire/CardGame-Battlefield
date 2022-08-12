package structures.basic.unit;

import structures.basic.*;

public class AzureHerald extends Unit {

    public AzureHerald() {
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public AzureHerald(int id, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animations, correction);
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public AzureHerald(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
        super(id, animations, correction, currentTile);
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public AzureHerald(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations, ImageCorrection correction) {
        super(id, animation, position, animations, correction);
        this.attack = 1;
        this.health = 4;
        this.intialHealth = 4;
    }

    public void summonedEffect(Unit unit) {
        if(unit.getHealth() < unit.getIntialHealth() - 3) {
            unit.setHealth(unit.getHealth() + 3);
        } else {
            unit.setHealth(unit.getIntialHealth());
        }
    }
}
