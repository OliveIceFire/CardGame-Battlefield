package structures.basic.spellCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.Tile;
import structures.basic.Unit;
import structures.basic.unit.HumanAvatar;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

import java.util.ArrayList;

public class EntropicDecayCard extends SpellCard {

    public EntropicDecayCard() {
        this.effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_martyrdom);
    }

    public EntropicDecayCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_martyrdom);
    }

    public void setCastableTile(Tile[][] tiles, ArrayList<Unit> units) {
        int tilex,tiley;
        for(Unit unit: units) {
            tilex = unit.getPosition().getTilex();
            tiley = unit.getPosition().getTiley();

            if(!(unit instanceof HumanAvatar) && unit.isFriendlyUnit()) {
                tiles[tilex][tiley].setCastable(true);
            }
        }
    }

    public void castSpell(Unit unit) {
        unit.setHealth(0);
    }
}
