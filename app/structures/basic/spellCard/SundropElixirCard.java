package structures.basic.spellCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.Tile;
import structures.basic.Unit;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

import java.util.ArrayList;

public class SundropElixirCard extends SpellCard {

    public SundropElixirCard() {
        this.effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_buff);
    }

    public SundropElixirCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_buff);
    }

    public void setCastableTile(Tile[][] tiles, ArrayList<Unit> units) {
        int tilex,tiley;
        for(Unit unit: units) {
            tilex = unit.getPosition().getTilex();
            tiley = unit.getPosition().getTiley();

            if(unit.isFriendlyUnit() && (unit.getHealth() < unit.getIntialHealth())) {
                tiles[tilex][tiley].setCastable(true);
            }
        }
    }

    public void castSpell(Unit unit) {
        if(unit.getIntialHealth() - unit.getHealth() > 5) {
            unit.setHealth(unit.getHealth() + 5);
        } else {
            unit.setHealth(unit.getIntialHealth());
        }
    }

}
