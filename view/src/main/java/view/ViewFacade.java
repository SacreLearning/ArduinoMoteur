package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IController;
import showboard.BoardFrame;
import model.element.Monster;
import model.element.Lorann;
import model.map.Map;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends Observable implements IView, Runnable, KeyListener {
	
	/**
	 * The controller interface
	 */
	private IController controller;
	
	/** The Constant WIDTH. */
    public int ROAD_WIDTH  = 20;

    /** The Constant HEIGHT. */
    public int ROAD_HEIGHT = 11;

    /** The Constant VIEW. */
    public final int ROAD_VIEW   = 14;
    
    /** The Constant speed. */
    private static final int speed = 300;
	
    /**
     * Game board
     */
	private BoardFrame boardFrame;
	
	/**
	 * View Rectangle
	 */
	private Rectangle roadView;
	
	/**
	 * Arbarr monster
	 */
	private Monster Arbarr;
	
	/**
	 * Cargyv monster
	 */
	private Monster Cargyv;
	
	/**
	 * Kyrac monster
	 */
	private Monster Kyrac;
	
	/**
	 * Maarcg monster
	 */
	private Monster Maarcg;
	
	/**
	 * Lorann
	 */
	private Lorann Lorann;
	

	/**
	 * View's ActionListener
	 */
	private ActionListener actionListener;
	
	/**
	 * View's KeyListener
	 */
	private KeyListener keyListener;

	/**
	 * Map actually on the board
	 */
	private Map map;
	
	/**
	 * Last board
	 */
	private BoardFrame lastBoardFrame;
	

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
        this.roadView = new Rectangle(0, 0, 20, 11);

        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    /**
     * Display map
     * @param map
     */
	@Override
	public void displayMap(Map map) {
		
	}
	
	
	/**
	 * Open window
	 */
	@Override
	public void runWindow() {
		
	
	}
	
	/**
	 * Legacy frame configuration
	 * @param frame
	 * @param map
	 */
	@Override
	public final void oldFrameConfigure(final BoardFrame frame, Map map) {
        
    }
	
	/**
	 * Get map attribute
	 * @return actual map on gameBoard
	 */
	@Override
	public Map getMap() {
		return map;
	}
	
	/**
	 * Set map attribute
	 * @param map
	 */
	@Override
	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * @return the actionListener
	 */
	@Override
	public ActionListener getActionListener() {
		return actionListener;
	}

	/**
	 * @param actionListener the actionListener to set
	 */
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/**
	 * @return the keyListener
	 */
	@Override
	public KeyListener getKeyListener() {
		return keyListener;
	}

	/**
	 * @param keyListener the keyListener to set
	 */
	@Override
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	
	/**
	 * Check if the door should be open or not
	 * @param isOpen
	 */
	@Override
	public void isDoorOpen(boolean isOpen) {
		this.map.setDoorPoint(isOpen);
		int x = this.map.getDoorPoint().x;
		int y = this.map.getDoorPoint().y;
		this.boardFrame.addSquare(this.map.getElement(y, x), x, y);
		this.toBlank(this.Lorann.getX(), this.Lorann.getY());
		this.NotifyAllOser();
	}
	
	/**
	 * Set square to blank
	 * @param x
	 * @param y
	 */
	@Override
	public void toBlank(int x, int y) {
		this.boardFrame.addSquare(this.map.getElement(y, x), x, y);
		this.NotifyAllOser();
	}
	
	/**
	 * 
	 * @param map
	 */
	@Override
	public void InitLevel(Map map) {
		this.setMap(map);		
		int columns = map.getColumns();
		int rows = map.getRows();
		for(int y=0; y<columns;y++) {
			for(int x=0; x<rows;x++) {
				boardFrame.addSquare(map.getElement(y, x), x, y);
			}
		}
		this.NotifyAllOser();
	}
	
	/**
	 * Initialise GameBoard with the map selected
	 * @param map
	 */
	@Override
	public void InitGameBoard(Map map) {
	
		
		this.boardFrame = new BoardFrame("Lorann Groupe 1 [Youssef, Romain, Pierre, Thomas, Paul]");
        this.addObserver(boardFrame.getObserver());
		int columns = map.getColumns();
		int rows = map.getRows();
        boardFrame.setDimension(new Dimension(rows, columns));
        this.roadView = new Rectangle(0, 0, rows, columns);
        boardFrame.setDisplayFrame(this.roadView);
        boardFrame.setSize(this.roadView.width * 40, this.roadView.height * 40);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);
        
		for(int y=0; y<columns;y++) {
			for(int x=0; x<rows;x++) {
				boardFrame.addSquare(map.getElement(y, x), x, y);
			}
		}
		
		
		if(this.getArbarr().getPosition() != null) {
			boardFrame.addPawn(this.getArbarr());
		}
		
		if(this.getCargyv().getPosition() != null) {
			boardFrame.addPawn(this.getCargyv());
		}
		
		if(this.getKyrac().getPosition() != null) {
			boardFrame.addPawn(this.getKyrac());
		}
		
		if(this.getMaarcg().getPosition() != null) {
			boardFrame.addPawn(this.getMaarcg());
		}
		
		if(this.getLorann().getPosition() != null) {
			boardFrame.addPawn(this.getLorann());
		}
		this.boardFrame.setVisible(true);
    	this.show();
	}
	
	/**
	 * Show loop
	 */
	public final void show() {
		this.getController().showLoop();
	}

	/**
	 * Notify every observer
	 * This.setChanged()
	 * This.notifyObservers()
	 */
	@Override
	public void NotifyAllOser() {
		this.setChanged();
		this.notifyObservers();
	}
	

	@Override
	public void run() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	/**
	 * KeyListener switch case check key
	 * z : moveUp
	 * s : moveDown
	 * q : moveLeft
	 * d : moveRight
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		this.getController().keyPressedListener(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	/**
	 * @return arbarr
	 */
	public Monster getArbarr() {
		return Arbarr;
	}

	/**
	 * @param arbarr
	 */
	@Override
	public void setArbarr(Monster arbarr) {
		Arbarr = arbarr;
	}
	
	/**
	 * @return Cargyv
	 */
	public Monster getCargyv() {
		return this.Cargyv;
	}

	/**
	 * @param cargyv
	 */
	@Override
	public void setCargyv(Monster cargyv) {
		this.Cargyv = cargyv;
	}

	/**
	 * @return the boardFrame
	 */
	@Override
	public BoardFrame getBoardFrame() {
		return boardFrame;
	}

	/**
	 * @param boardFrame the boardFrame to set
	 */
	@Override
	public void setBoardFrame(BoardFrame boardFrame) {
		this.boardFrame = boardFrame;
	}

	/**
	 * @return the kyrac
	 */
	@Override
	public Monster getKyrac() {
		return Kyrac;
	}

	/**
	 * @param kyrac the kyrac to set
	 */
	@Override
	public void setKyrac(Monster kyrac) {
		Kyrac = kyrac;
	}

	/**
	 * @return maarcg
	 */
	@Override
	public Monster getMaarcg() {
		return Maarcg;
	}

	/**
	 * @param maarcg
	 */
	@Override
	public void setMaarcg(Monster maarcg) {
		Maarcg = maarcg;
	}

	/**
	 * @return the lorann
	 */
	@Override
	public Lorann getLorann() {
		return Lorann;
	}

	/**
	 * @param lorann the lorann to set
	 */
	@Override
	public void setLorann(Lorann lorann) {
		Lorann = lorann;
	}

	/**
	 * @return the controller
	 */
	@Override
	public IController getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	@Override
	public void setController(IController controller) {
		this.controller = controller;
	}

}
