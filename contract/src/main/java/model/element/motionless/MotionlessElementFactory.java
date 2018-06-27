package model.element.motionless;

import java.io.IOException;

import model.element.Tile;

public abstract class MotionlessElementFactory {
	
	private static final Bone BONE = new Bone();
	private static final VerticalBone VERBONE = new VerticalBone();
	private static final HorizontalBone HORBONE = new HorizontalBone();
	private static final EnergyBall ENERGYBALL = new EnergyBall();
	private static final Bourse PURSE = new Bourse();
	private static final DoorClosed DOORCLOSED = new DoorClosed();
	private static final DoorOpen DOOROPEN = new DoorOpen();
	private static final Blank BLANK = new Blank();
	private static final WHITE WHITE = new WHITE();
	
	public static MotionlessElement createDoorClosed() throws IOException {
		return DOORCLOSED;
	}
	
	public static MotionlessElement createEnergyBall() throws IOException {
		return ENERGYBALL;
	}
	
	public static MotionlessElement createPurse() throws IOException {
		return PURSE;
	}
	
	public static MotionlessElement createHorizontalBone() throws IOException {
		return HORBONE;
	}
	
	public static MotionlessElement createBlank() throws IOException {
		return BLANK;
	}
	
	public static MotionlessElement createVerticalBone() throws IOException {
		return VERBONE;
	}
	
	public static MotionlessElement createBone() throws IOException {
		return BONE;
	}
	
	public static MotionlessElement createDoorOpen() throws IOException {
		return DOOROPEN;
	}
	
	public static MotionlessElement createWHITE() throws IOException {
		return WHITE;
	}
	

	
	public static void loadAllImage() {
		Tile tile;
		
		tile = new Tile(DOORCLOSED.getImageName());
		DOORCLOSED.setTile(tile);
		
		tile = new Tile(ENERGYBALL.getImageName());
		ENERGYBALL.setTile(tile);
		
		tile = new Tile(PURSE.getImageName());
		PURSE.setTile(tile);
		
		tile = new Tile(HORBONE.getImageName());
		HORBONE.setTile(tile);
		
		tile = new Tile(VERBONE.getImageName());
		VERBONE.setTile(tile);
		
		tile = new Tile(BONE.getImageName());
		BONE.setTile(tile);
		
		tile = new Tile(DOOROPEN.getImageName());
		DOOROPEN.setTile(tile);
		
		tile = new Tile(BLANK.getImageName());
		BLANK.setTile(tile);
		
		tile = new Tile(WHITE.getImageName());
		WHITE.setTile(tile);
		
	}

}
