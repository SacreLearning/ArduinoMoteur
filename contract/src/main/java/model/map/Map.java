package model.map;

import java.awt.Point;
import java.io.*;
import java.util.Scanner;
import model.element.Element;
import model.element.motionless.MotionlessElementFactory;

/**
 * 
 * @author Romain Dugarin
 * 
 * This Class creates a table in 2 dimensions which will contain the location of the elements
 * 
 */
public class Map {
	
	/** attribute containing the number of columns X */
	private int rows 		;
	
	/** attribute containing the number of lines Y */
	private int columns;
	
	/** attribute containing the number of the level */
	private int level		;
	/** attribute containing the maximum of the score */
	private int scoreMax	;

	/** attribute containing the score save */
	private int scoreSave	;
	
	/** Arbarr Position */
	private Point ArbarrPos = null;
	
	/** Cargyv Position */
	private Point CargyvPos = null;
	
	/** Kyrac Position */
	private Point KyracPos = null;
	
	/** Maarcg Position */
	private Point MaarcgPos = null;
	
	/** Lorann Position */
	private Point LorannPos = null;
	
	/** KeyRobot Position **/
	Point[] keyPosition = new Point[16];

	/** table containing the coordinates of the elements */
	private final Element[][] loadMap;

	/** Door position */
	private Point DoorPoint = null;
	
	/**
	 * Constructor of the map
	 * @param rows
	 * @param columns
	 * @param level
	 * @param scoreMax
	 * @param scoreSave
	 * @param map
	 * 
	 * Constructor of the map
	 * @throws IOException 
	 */
	public Map(int rows, int columns, int level, int scoreMax, int scoreSave, String map) throws IOException {
		this.rows = rows;
		this.columns = columns;
		this.level = level;
		this.setScoreMax(scoreMax);
		this.scoreSave = scoreSave;
		this.loadMap = new Element[this.getColumns()][this.getRows()];
		this.loadMap(map);
	}
	
		
	/**
	 * Add element on the map
	 * @param map
	 * @throws IOException 
	 *
	 */
	public void loadMap(String map) throws IOException {
		Scanner scn = new Scanner(map);
		String line = null;
		int yPos=0;
		int n;
		while (scn.hasNextLine()) {
			line = scn.nextLine();
			
	        for (int xPos=0; xPos<getRows(); xPos++) {
	        	switch( line.charAt(xPos) )	{
	    		case 'N':
	    			//ask for method DOOR_CLOSE
	    			MotionlessElementFactory.createDoorClosed().loadImage();
	    			this.DoorPoint = new Point(xPos, yPos);
	    			addElement(yPos, xPos, MotionlessElementFactory.createDoorClosed());
	                 break;
	    		case 'E':
	    			//ask for method
	    			MotionlessElementFactory.createEnergyBall().loadImage();
	    			addElement(yPos, xPos, MotionlessElementFactory.createEnergyBall());
	                break;
	    		case 'B':
	    			//ask for method
	    			MotionlessElementFactory.createPurse().loadImage();
	    			addElement(yPos, xPos, MotionlessElementFactory.createPurse());
	                break;
	    		case 'W':
	    			//ask for method
	    			MotionlessElementFactory.createHorizontalBone().loadImage();
	    			addElement(yPos, xPos, MotionlessElementFactory.createHorizontalBone());
	                break;
	    		case 'Z':
	    			//ask for method
	    			MotionlessElementFactory.createVerticalBone().loadImage();
	    			addElement(yPos, xPos, MotionlessElementFactory.createVerticalBone());
	                break;
	    		case 'O':
	    			//ask for method
	    			MotionlessElementFactory.createBone().loadImage();
	    			addElement(yPos, xPos, MotionlessElementFactory.createBone());
	                break;
	    		case 'D':
	    			//ask for method
	    			MotionlessElementFactory.createDoorOpen().loadImage();
	    			this.DoorPoint = new Point(xPos, yPos);
	    			addElement(yPos, xPos, MotionlessElementFactory.createDoorOpen());
	                break;
	    		case 'K':
	    			this.setKyracPos(new Point(xPos, yPos));
	    			MotionlessElementFactory.createBlank().loadImage();
	            	addElement(yPos, xPos, MotionlessElementFactory.createBlank());
	    			break;
	    		case 'C':
	    			this.setCargyvPos(new Point(xPos, yPos));
	    			MotionlessElementFactory.createBlank().loadImage();
	            	addElement(yPos, xPos, MotionlessElementFactory.createBlank());
	    			break;
	    		case 'A':
	    			this.setArbarrPos(new Point(xPos, yPos));
	    			MotionlessElementFactory.createBlank().loadImage();
	            	addElement(yPos, xPos, MotionlessElementFactory.createBlank());
	    			break;
	    		case 'M':
	    			this.setMaarcgPos(new Point(xPos, yPos));
	    			MotionlessElementFactory.createBlank().loadImage();
	            	addElement(yPos, xPos, MotionlessElementFactory.createBlank());
	    			break;
	    		case '0':
	    			this.setLorannPos(new Point(xPos, yPos));
	    			MotionlessElementFactory.createBlank().loadImage();
	            	addElement(yPos, xPos, MotionlessElementFactory.createBlank());
	            	keyPosition[0] = new Point(xPos, yPos);
           		 	System.out.println(keyPosition[0]);
	    			break;
	    		case '_':
	    			MotionlessElementFactory.createBlank().loadImage();
	            	addElement(yPos, xPos, MotionlessElementFactory.createBlank());
	    			break;
	            default:
	            	try {
	            		n = (int)line.charAt(xPos)-48;
		            	 if ( n >= 0 && n < 16 ){
		            		 keyPosition[n] = new Point(xPos, yPos);
		            		 System.out.println(keyPosition[n]);
		                 }
	            	} catch(Exception e) {
	            		e.getMessage();
	            	}
	            	
	            	 MotionlessElementFactory.createBlank().loadImage();
	            	addElement(yPos, xPos, MotionlessElementFactory.createBlank());
	            	break;
	        	}    
			}
	        yPos++;
			
			
		}
		
	}
	
	/**
	 * Method that add element in the table 
	 * 
	 * @param yPos
	 * @param xPos
	 * @param element
	 */
	public void addElement(int yPos, int xPos, Element element)	{
		this.loadMap[yPos][xPos] = element;
	}
	
	public Point getKeyPos(int id) {
		return keyPosition[id];
	}
	
	public Element getElement(int yPos, int xPos)	{
		return this.loadMap[yPos][xPos];
	}
	
	/**
	 * @return return the rows attribute
	 * @see Map 
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * @return return the columns attribute
	 * @see Map 
	 */
	public int getColumns()	{
		return columns;
	}
	
	/**
	 * @return return the scoreSave attribute
	 * @see Map 
	 */
	public int getScoreSave()	{
		return scoreSave;
	}
	
	/**
	 * @return return the level attribute
	 * @see Map 
	 */
	public int getLevel()	{
		return level;
	}
	
	/**
	 * 
	 * @param rows
	 */
	public void setRows(int rows)	{
		this.rows = rows;
	}
	
	/**
	 * 
	 * @param columns
	 */
	public void setColumns(int columns)	{
		this.columns = columns;
	}


	/**
	 * @return the scoreMax
	 */
	public int getScoreMax() {
		return scoreMax;
	}


	/**
	 * @param scoreMax the scoreMax to set
	 */
	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}


	/**
	 * @return the arbarrPos
	 */
	public Point getArbarrPos() {
		return ArbarrPos;
	}


	/**
	 * @param arbarrPos the arbarrPos to set
	 */
	public void setArbarrPos(Point arbarrPos) {
		ArbarrPos = arbarrPos;
	}


	/**
	 * @return the cargyvPos
	 */
	public Point getCargyvPos() {
		return CargyvPos;
	}


	/**
	 * @param cargyvPos the cargyvPos to set
	 */
	public void setCargyvPos(Point cargyvPos) {
		CargyvPos = cargyvPos;
	}


	/**
	 * @return the maarcgPos
	 */
	public Point getMaarcgPos() {
		return MaarcgPos;
	}


	/**
	 * @param maarcgPos the maarcgPos to set
	 */
	public void setMaarcgPos(Point maarcgPos) {
		MaarcgPos = maarcgPos;
	}


	/**
	 * @return the lorannPos
	 */
	public Point getLorannPos() {
		return LorannPos;
	}


	/**
	 * @param lorannPos the lorannPos to set
	 */
	public void setLorannPos(Point lorannPos) {
		LorannPos = lorannPos;
	}


	/**
	 * @return the kyracPos
	 */
	public Point getKyracPos() {
		return KyracPos;
	}


	/**
	 * The kyracPos to set
	 * @param kyracPos 
	 */
	public void setKyracPos(Point kyracPos) {
		KyracPos = kyracPos;
	}


	/**
	 * @return the doorPoint
	 */
	public Point getDoorPoint() {
		return DoorPoint;
	}
	
	/**
	 * Set to blank
	 * @param x
	 * @param y
	 */
	public void setToBlank(int x, int y) {
		try {
			MotionlessElementFactory.createBlank().loadImage();
			addElement(y, x, MotionlessElementFactory.createBlank());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Open or Close door
	 * @param isOpen
	 */
	public void setDoorPoint(boolean isOpen) {
		if(isOpen) {
			try {
				MotionlessElementFactory.createDoorOpen().loadImage();
				addElement(this.getDoorPoint().y, this.getDoorPoint().x, MotionlessElementFactory.createDoorOpen());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				MotionlessElementFactory.createDoorClosed().loadImage();
				addElement(this.getDoorPoint().y, this.getDoorPoint().x, MotionlessElementFactory.createDoorClosed());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}