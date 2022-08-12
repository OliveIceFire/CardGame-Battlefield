package structures.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import structures.GameState;
import utils.BasicObjectBuilders;
import utils.StaticConfFiles;

/**
 * This is a representation of a Unit on the game board.
 * A unit has a unique id (this is used by the front-end.
 * Each unit has a current UnitAnimationType, e.g. move,
 * or attack. The position is the physical position on the
 * board. UnitAnimationSet contains the underlying information
 * about the animation frames, while ImageCorrection has
 * information for centering the unit on the tile. 
 * 
 * @author Dr. Richard McCreadie
 *
 */
public class Unit {

	@JsonIgnore
	protected static ObjectMapper mapper = new ObjectMapper(); // Jackson Java Object Serializer, is used to read java objects from a file
	
	protected int id;
	protected UnitAnimationType animation;
	protected Position position;
	protected UnitAnimationSet animations;
	protected ImageCorrection correction;

	protected EffectAnimation effectAnimation = BasicObjectBuilders.loadEffect(StaticConfFiles.f1_summon);

	protected int attack;
	protected int health;
	protected int intialHealth;
	protected boolean movable = false;
	protected boolean attackable = false;
	protected boolean friendlyUnit = true;
	protected boolean ranged = false;
	private Tile bestAttackPoint;
	
	public Unit() {}
	
	public Unit(int id, UnitAnimationSet animations, ImageCorrection correction) {
		super();
		this.id = id;
		this.animation = UnitAnimationType.idle;
		
		position = new Position(0,0,0,0);
		this.correction = correction;
		this.animations = animations;
	}
	
	public Unit(int id, UnitAnimationSet animations, ImageCorrection correction, Tile currentTile) {
		super();
		this.id = id;
		this.animation = UnitAnimationType.idle;

		position = new Position(currentTile.getXpos(),currentTile.getYpos(),currentTile.getTilex(),currentTile.getTiley());
		this.correction = correction;
		this.animations = animations;
	}



	public Unit(int id, UnitAnimationType animation, Position position, UnitAnimationSet animations,
			ImageCorrection correction) {
		super();
		this.id = id;
		this.animation = animation;
		this.position = position;
		this.animations = animations;
		this.correction = correction;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UnitAnimationType getAnimation() {
		return animation;
	}
	public void setAnimation(UnitAnimationType animation) {
		this.animation = animation;
	}

	public ImageCorrection getCorrection() {
		return correction;
	}

	public void setCorrection(ImageCorrection correction) {
		this.correction = correction;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public UnitAnimationSet getAnimations() {
		return animations;
	}

	public void setAnimations(UnitAnimationSet animations) {
		this.animations = animations;
	}

	public EffectAnimation getEffectAnimation() {
		return effectAnimation;
	}

	public void setEffectAnimation(EffectAnimation effectAnimation) {
		this.effectAnimation = effectAnimation;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getIntialHealth() {
		return intialHealth;
	}

	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	public boolean isAttackable() {
		return attackable;
	}

	public void setAttackable(boolean attackable) {
		this.attackable = attackable;
	}

	public boolean isRanged() {
		return ranged;
	}

	public boolean isFriendlyUnit() {
		return friendlyUnit;
	}

	public void setFriendlyUnit(boolean friendlyUnit) {
		this.friendlyUnit = friendlyUnit;
	}

	public void setBestAttackPoint(Tile[][] tiles,int tilex, int tiley){ this.bestAttackPoint= tiles[tilex][tiley];};

	public void clearBestAttackPoint(){ this.bestAttackPoint=null; }

	public Tile getBestAttackPoint(){ return this.bestAttackPoint;}


	/**
	 * This command sets the position of the Unit to a specified
	 * tile.
	 * @param tile
	 */
	@JsonIgnore
	public void setPositionByTile(Tile tile) {
		position = new Position(tile.getXpos(),tile.getYpos(),tile.getTilex(),tile.getTiley());
	}

	public void setMovableTile(Tile[][] tiles, int tilex, int tiley) {
		for (int i = 1; i < 3; i++) {
			Tile checkTile;
			if ((tilex + i) <= 8) {
				checkTile = tiles[tilex + i][tiley];
				if (checkTile.getUnit() == null) {
					checkTile.setMovable(true);
				}
				if (i == 1) {
					if ((tiley + i) <= 4) {
						checkTile = tiles[tilex + i][tiley + i];
						if (checkTile.getUnit() == null) {
							checkTile.setMovable(true);
						}
					}
				}
			}
			if ((tilex - i) >= 0) {
				checkTile = tiles[tilex - i][tiley];
				if (checkTile.getUnit() == null) {
					checkTile.setMovable(true);
				}
				if (i == 1) {
					if ((tiley - i) >= 0) {
						checkTile = tiles[tilex - i][tiley - i];
						if (checkTile.getUnit() == null) {
							checkTile.setMovable(true);
						}
					}
				}
			}
			if ((tiley + i) <= 4) {
				checkTile = tiles[tilex][tiley + i];
				if (checkTile.getUnit() == null) {
					checkTile.setMovable(true);
				}
				if (i == 1) {
					if ((tilex - i) >= 0) {
						checkTile = tiles[tilex - i][tiley + i];
						if (checkTile.getUnit() == null) {
							checkTile.setMovable(true);
						}
					}
				}
			}
			if ((tiley - i) >= 0) {
				checkTile = tiles[tilex][tiley - i];
				if (checkTile.getUnit() == null) {
					checkTile.setMovable(true);
				}
				if (i == 1) {
					if ((tilex + i) <= 8) {
						checkTile = tiles[tilex + i][tiley - i];
						if (checkTile.getUnit() == null) {
							checkTile.setMovable(true);
						}
					}
				}
			}
		}
	}

	public void setMoveAndAttackable(Tile[][] tiles){
		for(int i=0; i< 9; i++) {
			for(int j=0; j< 5; j++) {
				Tile tile = tiles[i][j];
				if(tile.isMovable()){
					this.setAttackableTile(tiles, i, j);
				}
			}
		}
	}

	public void setAttackableTile(Tile[][] tiles, int tilex, int tiley) {
		if(tilex + 1 <= 8) {
			if(tiles[tilex + 1][tiley].getUnit() != null && !tiles[tilex + 1][tiley].getUnit().isFriendlyUnit()) {
				tiles[tilex + 1][tiley].setAttackable(true);
				tiles[tilex + 1][tiley].getUnit().setBestAttackPoint(tiles, tilex, tiley);
			}
			if(tiley + 1 <= 4) {
				if(tiles[tilex + 1][tiley + 1].getUnit() != null && !tiles[tilex + 1][tiley + 1].getUnit().isFriendlyUnit()) {
					tiles[tilex + 1][tiley + 1].setAttackable(true);
					tiles[tilex + 1][tiley + 1].getUnit().setBestAttackPoint(tiles,tilex,tiley);
				}
			}
		}
		if(tilex - 1 >= 0) {
			if(tiles[tilex - 1][tiley].getUnit() != null && !tiles[tilex - 1][tiley].getUnit().isFriendlyUnit()) {
				tiles[tilex - 1][tiley].setAttackable(true);
				tiles[tilex - 1][tiley].getUnit().setBestAttackPoint(tiles,tilex,tiley);
			}
			if(tiley - 1 >= 0) {
				if(tiles[tilex - 1][tiley - 1].getUnit() != null && !tiles[tilex - 1][tiley - 1].getUnit().isFriendlyUnit()) {
					tiles[tilex - 1][tiley - 1].setAttackable(true);
					tiles[tilex - 1][tiley - 1].getUnit().setBestAttackPoint(tiles,tilex,tiley);
				}
			}
		}
		if(tiley + 1 <= 4) {
			if(tiles[tilex][tiley + 1].getUnit() != null && !tiles[tilex][tiley + 1].getUnit().isFriendlyUnit()) {
				tiles[tilex][tiley + 1].setAttackable(true);
				tiles[tilex][tiley + 1].getUnit().setBestAttackPoint(tiles,tilex,tiley);
			}
			if(tilex - 1 >= 0) {
				if(tiles[tilex - 1][tiley + 1].getUnit() != null && !tiles[tilex - 1][tiley + 1].getUnit().isFriendlyUnit()) {
					tiles[tilex - 1][tiley + 1].setAttackable(true);
					tiles[tilex - 1][tiley + 1].getUnit().setBestAttackPoint(tiles,tilex,tiley);
				}
			}
		}
		if(tiley - 1 >= 0) {
			if(tiles[tilex][tiley - 1].getUnit() != null && !tiles[tilex][tiley - 1].getUnit().isFriendlyUnit()) {
				tiles[tilex][tiley - 1].setAttackable(true);
				tiles[tilex][tiley - 1].getUnit().setBestAttackPoint(tiles,tilex,tiley);
			}
			if(tilex + 1 <= 8) {
				if(tiles[tilex + 1][tiley - 1].getUnit() != null && !tiles[tilex + 1][tiley - 1].getUnit().isFriendlyUnit()) {
					tiles[tilex + 1][tiley - 1].setAttackable(true);
					tiles[tilex + 1][tiley - 1].getUnit().setBestAttackPoint(tiles,tilex,tiley);
				}
			}
		}
	}

}
