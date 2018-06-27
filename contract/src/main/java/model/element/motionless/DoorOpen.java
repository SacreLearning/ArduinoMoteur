package model.element.motionless;

public class DoorOpen extends MotionlessElement {
	
	private static final char SPRITE = 'N';
	private static final String TILE = "gate_open.png";
	
	public DoorOpen() {
		super(SPRITE, TILE);
	}
}
