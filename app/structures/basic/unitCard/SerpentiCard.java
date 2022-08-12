package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.Serpenti;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class SerpentiCard extends UnitCard {

    public SerpentiCard(){
        this.attack = 7;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_serpenti, id++, Serpenti.class);
    }

    public SerpentiCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 7;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_serpenti, id++, Serpenti.class);
    }

}
