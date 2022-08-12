package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.HailstoneGolem;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class HailstoneGolemCard extends UnitCard {

    public HailstoneGolemCard(){
        this.attack = 4;
        this.health = 6;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_hailstone_golem, id++, HailstoneGolem.class);
    }

    public HailstoneGolemCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 4;
        this.health = 6;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_hailstone_golem, id++, HailstoneGolem.class);
    }

}
