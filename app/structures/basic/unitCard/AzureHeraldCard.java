package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.AzureHerald;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class AzureHeraldCard extends UnitCard {

    public AzureHeraldCard(){
        this.attack = 1;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_azure_herald, id++, AzureHerald.class);
    }

    public AzureHeraldCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 1;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_azure_herald, id++, AzureHerald.class);
    }

}
