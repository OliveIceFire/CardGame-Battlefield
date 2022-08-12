package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.SilverguardKnight;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class SilverguardKnightCard extends UnitCard {

    public SilverguardKnightCard(){
        this.attack = 1;
        this.health = 5;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_silverguard_knight, id++, SilverguardKnight.class);
    }

    public SilverguardKnightCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 1;
        this.health = 5;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_silverguard_knight, id++, SilverguardKnight.class);
    }

}
