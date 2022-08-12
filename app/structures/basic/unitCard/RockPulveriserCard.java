package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.RockPulveriser;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class RockPulveriserCard extends UnitCard {

    public RockPulveriserCard(){
        this.attack = 1;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_rock_pulveriser, id++, RockPulveriser.class);
    }

    public RockPulveriserCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 1;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_rock_pulveriser, id++, RockPulveriser.class);
    }

}
