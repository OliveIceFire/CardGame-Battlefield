package structures.basic.spellCard;

import structures.basic.*;

import java.util.ArrayList;

public class SpellCard extends Card {

    protected EffectAnimation effectAnimation;

    public SpellCard(){}

    public SpellCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
    }

    public EffectAnimation getEffectAnimation() {
        return this.effectAnimation;
    }

    public void setEffectAnimation(EffectAnimation effectAnimation) {
        this.effectAnimation = effectAnimation;
    }

    public void setCastableTile(Tile[][] tiles, ArrayList<Unit> units) {
        int tilex,tiley;
        for(Unit unit: units) {
            tilex = unit.getPosition().getTilex();
            tiley = unit.getPosition().getTiley();

            tiles[tilex][tiley].setCastable(true);
        }
    }

    public void castSpell(Unit unit) {

    }

}
