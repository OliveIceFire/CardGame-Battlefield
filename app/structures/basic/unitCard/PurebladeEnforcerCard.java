package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.unit.PurebladeEnforcer;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

public class PurebladeEnforcerCard extends UnitCard {

    public PurebladeEnforcerCard(){
        this.attack = 1;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_pureblade_enforcer, id++, PurebladeEnforcer.class);
    }

    public PurebladeEnforcerCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 1;
        this.health = 4;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_pureblade_enforcer, id++, PurebladeEnforcer.class);
    }

}
