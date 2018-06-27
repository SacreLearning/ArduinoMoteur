package model.element.motionless;

public class Blank extends MotionlessElement {
	
	private static final char SPRITE = ' ';
	private static final String TILE = "blank.png";
	
	public Blank() {
		super(SPRITE, TILE);
	}
}
