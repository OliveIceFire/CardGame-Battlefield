package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.Windshrike;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class WindshrikeCard extends UnitCard {

    public WindshrikeCard(){
        this.attack = 4;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_windshrike, id++, Windshrike.class);
    }

    public WindshrikeCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 4;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_windshrike, id++, Windshrike.class);
    }

}
