package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.FireSpitter;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class FireSpitterCard extends UnitCard {

    public FireSpitterCard(){
        this.attack = 3;
        this.health = 2;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_fire_spitter, id++, FireSpitter.class);
    }

    public FireSpitterCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 3;
        this.health = 2;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_fire_spitter, id++, FireSpitter.class);
    }

}
