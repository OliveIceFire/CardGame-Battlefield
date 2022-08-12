package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.ComodoCharger;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class ComodoChargerCard extends UnitCard {

    public ComodoChargerCard(){
        this.attack = 1;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_comodo_charger, id++, ComodoCharger.class);
    }

    public ComodoChargerCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 1;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_comodo_charger, id++, ComodoCharger.class);
    }

}
