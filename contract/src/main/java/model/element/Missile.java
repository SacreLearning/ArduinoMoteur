package model.element;

import java.awt.Point;
import java.io.IOException;
import java.util.Arrays;

import model.map.Map;
import showboard.IPawn;

public class Missile extends Tile implements IPawn {

	/** Missile range DEPRECATED */
    private final int MISSILE_RANGE = 3;
    
    /** Fireball color */
    private String TILE[];
    
    /** Element the missile can pass throught */
    private Character[] Allowed;
    
    /** Position on the loopMissile() */
    private int loopPos;
    
    /** Missile's position */
    private Point position;
    
    /** Missile's Direction X */
    private int xDir;
    
    /** Missile's Direction Y */
    private int yDir;

    /**
     * Missile Constructor
     * @param x
     * @param y
     * @param xPos
     * @param yPos
     */
    public Missile(int x, int y, int xPos, int yPos) {
        super("fireball_1.png");
        this.position = new Point(xPos, yPos);
        this.xDir = x;
        this.yDir = y;
        this.Allowed = new Character[] { ' ', 'B', 'E' };
        TILE = new String[5];
        TILE[0] = "fireball_1.png";
        TILE[1] = "fireball_2.png";
        TILE[2] = "fireball_3.png";
        TILE[3] = "fireball_4.png";
        TILE[4] = "fireball_5.png";
        initMissile();
    }
    
    /**
     * Create new missile if needed, Used for Missile's AI
     * @param x
     * @param y
     * @param xPos
     * @param yPos
     */
    public void newMissile(int x, int y, int xPos, int yPos) {
        this.position = new Point(xPos, yPos);
        this.xDir = x;
        this.yDir = y;
        initMissile();
    }
    
    /**
	 * Animation of Missile
	 */
	public void loopMissile() {
		this.loopPos = (this.loopPos+1) % (this.TILE.length-1);
		/*if(this.loopPos>this.TILE.length-1) {
			this.loopPos = 0;
		}*/
		this.setImageName(this.TILE[this.loopPos]);
		try {
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	/**
	 * Initialize Missile
	 */
    private void initMissile() {
        
    	try {
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /** Missile's AI */
    public void move(Map map) {
    	int x = this.getPosition().x+this.xDir;
    	int y = this.getPosition().y+this.yDir;
    	boolean ifExists = Arrays.asList(Allowed).contains(map.getElement(y, x).getSprite());
    	if(ifExists) {
    		this.getPosition().x = x;
    		this.getPosition().y = y;
    	}else {
    		this.xDir = (this.xDir*-1);
    		this.yDir = (this.yDir*-1);
    		x = this.getPosition().x+this.xDir;
    		y = this.getPosition().y+this.yDir;
    		this.getPosition().x = x;
    		this.getPosition().y = y;
    	}
    	 
    
    }

    /**
     * @return int Missile's X position
     */
	@Override
	public int getX() {
		return position.x;
	}

	/**
	 * @return int Missile's Y position
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return position.y;
	}

	/**
	 * @return Point Missile's position
	 */
	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return position;
	}
}
