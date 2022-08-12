package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.BloodshardGolem;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class BloodshardGolemCard extends UnitCard {

    public BloodshardGolemCard(){
        this.attack = 4;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_bloodshard_golem, id++, BloodshardGolem.class);
    }

    public BloodshardGolemCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 4;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_bloodshard_golem, id++, BloodshardGolem.class);
    }

}
