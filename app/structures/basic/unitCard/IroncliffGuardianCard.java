package structures.basic.unitCard;

import structures.basic.BigCard;
import structures.basic.MiniCard;
import structures.basic.Tile;
import structures.basic.Unit;
import structures.basic.unit.IroncliffGuardian;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

import java.util.ArrayList;

public class IroncliffGuardianCard extends UnitCard {

    public IroncliffGuardianCard(){
        this.attack = 3;
        this.health = 10;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_ironcliff_guardian, id++, IroncliffGuardian.class);
    }

    public IroncliffGuardianCard(int id, String cardname, int manacost, MiniCard miniCard, BigCard bigCard) {
        super(id, cardname, manacost, miniCard, bigCard);
        this.attack = 3;
        this.health = 10;
        this.unit = BasicObjectBuilders.loadUnit(StaticConfFiles.u_ironcliff_guardian, id++, IroncliffGuardian.class);
    }

    public void setSummonableTile(Tile[][] tiles, ArrayList<Unit> units) {
        for(int i=0; i< 9; i++) {
            for(int j=0; j< 5; j++) {
                Tile tile = tiles[i][j];
                if(tile.getUnit() == null) {
                    tile.setSummonable(true);
                }
            }
        }
    }

}
