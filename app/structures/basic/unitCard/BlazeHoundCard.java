package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.BlazeHound;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class BlazeHoundCard extends UnitCard {

    public BlazeHoundCard(){
        this.attack = 4;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_blaze_hound, id++, BlazeHound.class);
    }

    public BlazeHoundCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 4;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_blaze_hound, id++, BlazeHound.class);
    }

}
