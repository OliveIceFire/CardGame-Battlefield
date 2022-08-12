package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.AzuriteLion;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class AzuriteLionCard extends UnitCard {

    public AzuriteLionCard(){
        this.attack = 2;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_azurite_lion, id++, AzuriteLion.class);
    }

    public AzuriteLionCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 2;
        this.health = 3;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_azurite_lion, id++, AzuriteLion.class);
    }
}
