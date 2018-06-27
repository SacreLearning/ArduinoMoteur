package model.element.motionless;


public class Bone extends MotionlessElement {
	
	private static final char SPRITE = 'W';
	private static final String TILE = "bone.png";
	
	public Bone() {
		super(SPRITE, TILE);
	}
}
