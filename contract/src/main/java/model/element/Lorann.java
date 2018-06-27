package model.element;

import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

import showboard.IPawn;

public class Lorann extends Tile implements IMobile {
	
	/** Init TILE */
	private static String TILEB = "lorann_b.png";
	
	/** Loop Position */
	private int loopPos;
	
	/** String array of Tile */
	private String[] TILE = new String[8];
	
	/** Init Sprite */
	private static char SPRITE = '1';
	
	/** Direction of the player */
	private Point Dir;
	
	/** Position of the player */
	private Point point;
	
	/** Is Player alive ? */
	private boolean isAlive;
	
	/** Player has key ? */
	private boolean hasKey;
	
	/** Spell of the player */
	private Missile spell;
	
	
	
	/**
	 * Player Constructor
	 * @param x
	 * @param y
	 * @param isAlive
	 */
	public Lorann(int x, int y, boolean isAlive) {
		super(TILEB);
		this.Dir = new Point(0, 1);
		this.point = new Point(x, y);
		this.isAlive = isAlive;
		this.hasKey = false;
		this.loopPos = 0;
		TILE[0] = "lorann_b.png";
		TILE[1] = "lorann_br.png";
		TILE[2] = "lorann_r.png";
		TILE[3] = "lorann_ur.png";
		TILE[4] = "lorann_u.png";
		TILE[5] = "lorann_ul.png";
		TILE[6] = "lorann_l.png";
		TILE[7] = "lorann_bl.png";
		
		
		try {
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Animation of lorann's face
	 */
	@Override
	public void loopLorannFace() {
		this.loopPos = (this.loopPos+1) % (this.TILE.length-1);
		/*if(this.loopPos>this.TILE.length-1) {
			this.loopPos = 0;
		}*/
		if(isAlive) {
			this.setImageName(this.TILE[this.loopPos]);
		}else {
			this.setImageName('u'+this.TILE[this.loopPos]);
		}
		
		try {
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Change Lorann's face
	 * @param t
	 * 		String of the face
	 */
	private void changePosition(final String t) {
		
		try {
			if(isAlive) {
				this.setImageName(t);
				
			}else {
				this.setImageName('u'+t);
			}
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** Move up */
	@Override
	public void moveUp() {
		changePosition(TILE[4]);
		this.Dir.x = 0;
		this.Dir.y = -1;
		this.getPosition().y += -1;
	}

	/** Move Left */
	@Override
	public void moveLeft() {
		this.Dir.x = -1;
		this.Dir.y = 0;
		changePosition(TILE[6]);
		this.getPosition().x += -1;
		
	}
	
	/** Move Down */
	@Override
	public void moveDown() {
		changePosition(TILE[0]);
		this.Dir.x = 0;
		this.Dir.y = 1;
		this.getPosition().y += 1;
		
	}

	/** Move Right */
	@Override
	public void moveRight() {
		changePosition(TILE[2]);
		this.Dir.x = 1;
		this.Dir.y = 0;
		this.getPosition().x += 1;
		
	}
	
	/** Move with the direction of the player */
	@Override
	public void moveDir(int x, int y) {
		if(x == -1) {
			if(y == -1) {
				changePosition(TILE[5]);
				this.getPosition().y += y;
				this.getPosition().x += x;
				this.Dir.x = x;
				this.Dir.y = y;
			}
			
			if(y == 1) {
				changePosition(TILE[7]);
				this.getPosition().y += y;
				this.getPosition().x += x;
				this.Dir.x = x;
				this.Dir.y = y;
			}
		}
		
		if(x == 1) {
			if(y == 1) {
				changePosition(TILE[1]);
				this.getPosition().y += y;
				this.getPosition().x += x;
				this.Dir.x = x;
				this.Dir.y = y;
			}
			
			if(y == -1) {
				changePosition(TILE[3]);
				this.getPosition().y += y;
				this.getPosition().x += x;
				this.Dir.x = x;
				this.Dir.y = y;
			}
		}
	}
	
	/**
	 * Summon lorann's spell
	 */
	@Override
	public Missile summonSpell() {
		return new Missile(this.Dir.x, this.Dir.y, this.getX()+this.Dir.x, this.getY()+this.Dir.y);
	}

	/**
	 * Do nothing
	 */
	@Override
	public void doNothing() {
		System.out.println("Nothing");
		
	}

	/**
	 * @return X Position
	 */
	@Override
	public int getX() {
		return this.point.x;
	}

	/**
	 * @return Y Position
	 */
	@Override
	public int getY() {
		return this.point.y;
	}

	/**
	 * @return The player state
	 */
	@Override
	public Boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * @param isAlive
	 * 		Check if player is dead
	 */
	@Override
	public int isDead(Boolean isAlive) {
		
		this.isAlive = !isAlive;
		
		
		if(!isAlive()) {
			return 0;
		}else {
			return 1;
		}
	}

	/**
	 * @return The position
	 */
	@Override
	public Point getPosition() {
		return this.point;
	}
	
	/**
	 * @param point
	 * 		Position
	 */
	@Override
	public void setPosition(Point point) {
		this.point = point;
	}

	/**
	 * @return the hasKey
	 */
	public boolean isHasKey() {
		return hasKey;
	}

	/**
	 * @param hasKey the hasKey to set
	 */
	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}
	
	/**
	 * @return Point
	 */
	@Override
	public Point getDir() {
		return this.Dir;
	}

	/**
	 * @return the spell
	 */
	@Override
	public Missile getSpell() {
		return spell;
	}

	/**
	 * @param spell the spell to set
	 */
	@Override
	public void setSpell(Missile spell) {
		this.spell = spell;
	}


}
