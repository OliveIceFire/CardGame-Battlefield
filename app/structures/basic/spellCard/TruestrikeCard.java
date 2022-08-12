package structures.basic.spellCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.Tile;
import structures.basic.Unit;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

import java.util.ArrayList;

public class TruestrikeCard extends SpellCard {

    public TruestrikeCard() {
        this.effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_inmolation);
    }

    public TruestrikeCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_inmolation);
    }

    public void setCastableTile(Tile[][] tiles, ArrayList<Unit> units) {
        int tilex,tiley;
        for(Unit unit: units) {
            tilex = unit.getPosition().getTilex();
            tiley = unit.getPosition().getTiley();

            if(!unit.isFriendlyUnit()) {
                tiles[tilex][tiley].setCastable(true);
            }
        }
    }

    public void castSpell(Unit unit) {
        if(unit.getHealth() > 2) {
            unit.setHealth(unit.getHealth() - 2);
        } else {
            unit.setHealth(0);
        }
    }

}
