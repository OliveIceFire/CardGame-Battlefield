package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.Pyromancer;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class PyromancerCard extends UnitCard {

    public PyromancerCard(){
        this.attack = 2;
        this.health = 1;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_pyromancer, id++, Pyromancer.class);
    }

    public PyromancerCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 2;
        this.health = 1;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_pyromancer, id++, Pyromancer.class);
    }

}
