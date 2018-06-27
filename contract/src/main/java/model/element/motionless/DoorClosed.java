package model.element.motionless;

public class DoorClosed extends MotionlessElement {
	
	private static final char SPRITE = 'D';
	private static final String TILE = "gate_closed.png";
	
	public DoorClosed() {
		super(SPRITE, TILE);
	}
}