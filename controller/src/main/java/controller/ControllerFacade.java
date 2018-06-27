package controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import model.IModel;
import model.IA.Arbarr;
import model.IA.Cargyv;
import model.IA.Maarcg;
import model.dao.SerialTest;
import model.IA.Kyrac;
import model.element.Element;
import model.element.Lorann;
import model.element.Monster;
import model.element.motionless.MotionlessElementFactory;
import model.map.Map;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController{

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    
    /** Actual map */
    private Map map;
    
    /** Arbarr /MONSTER/ */
    private Monster Arbarr = new Monster("arbarr.png", new Arbarr(), 0, 0);
    
    /** Cargyv /MONSTER/ */
    private Monster Cargyv = new Monster("cargyv.png", new Cargyv(), 0, 0);

    /** Maarcg /MONSTER/ */
    private Monster Maarcg = new Monster("maarcg.png", new Maarcg(), 0,0);
    
    /** Kyrac /MONSTER/ */
    private Monster Kyrac = new Monster("kyrac.png", new Kyrac(), 0, 0);
    
    /** Lorann /PLAYER/ */
    private Lorann Lorann = new Lorann(0, 0, true);
    
    /** Lorann Friend Multiplayer usage DEPRECATED */
    private Lorann Friend = new Lorann(0, 0, true);

    /** Player score on the map */
	private int Score;
	
	SerialTest ST = new SerialTest();
	
	/** Lorann last known position*/
	Point GPS = null;
	
	
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.getView().setController(this);
       // this.view.setKeyListener(this);
        this.model = model;
        
        
	    ST.initialize();
	    Thread t=new Thread() {
	    
	    	public void run() {
		    //the following line will keep this app alive for 1000 seconds,
		    //waiting for events to occur and responding to them (printing incoming messages to console).
			    try {
			    	Thread.sleep(1000000);
			    }
			    catch (InterruptedException ie) {
			    	
			    }
	    
	    	}
	    	
	    };
	    t.start();
	    
	    System.out.println(" Started ");
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start(int id) throws SQLException {
    	
  	
    	MotionlessElementFactory.loadAllImage();
		map = this.model.getMapById(id);
		
		
		Arbarr.setPosition(map.getKyracPos());
		Cargyv.setPosition(map.getCargyvPos());
		Maarcg.setPosition(map.getMaarcgPos());
		Kyrac.setPosition(map.getKyracPos());
		Lorann.setPosition(map.getLorannPos());
		
		map.setDoorPoint(false);
		this.view.setArbarr(Arbarr);
		this.view.setCargyv(Cargyv);
		this.view.setKyrac(Kyrac);
		this.view.setMaarcg(Maarcg);
		this.view.setLorann(Lorann);
		
		
        this.view.setMap(map);
        this.view.InitGameBoard(map);
        
        
        
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
    /** Controller getKey */
    private void getKey() {
    	this.Lorann.setHasKey(true);
		this.getView().isDoorOpen(this.Lorann.isHasKey());
		this.getView().NotifyAllOser();
		System.out.println("HasKey");
    }
    
    /** Remplace taken item */
    private void itemTaken(int x, int y) {
    	this.map.setToBlank(x, y);
    	this.getView().toBlank(x, y);
    }
    
    /** Go to next level */
    private void nextLevel() {
    	
    	/*map = this.model.getMapById(this.getMap().getLevel()+1);
		
		
		Arbarr.setPosition(map.getKyracPos());
		Cargyv.setPosition(map.getCargyvPos());
		Maarcg.setPosition(map.getMaarcgPos());
		Kyrac.setPosition(map.getKyracPos());
		Lorann.setPosition(map.getLorannPos());
		
		map.setDoorPoint(false);
		this.getView().setMap(map);*/
    	this.view.getBoardFrame().setVisible(false);
    	System.exit(0);
    }
    
    /** Get lorann's spell */
    private void spellTaken() {
    	this.Lorann.getSpell().setImageName("transp.png");
    	try {
			this.Lorann.getSpell().loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /** Identify player death */
    private void KillPlayer() {
    	int numberDeath = this.Lorann.isDead(true);
    }
    
    private void moveLorannGPS() {
    	if(ST.getActualPos() <= ST.getTotalPos()) {
    		 GPS = map.getKeyPos(ST.getNextPos());
    		 //System.out.println(GPS);
    	}
    	if(Lorann.getPosition().x != GPS.x || Lorann.getPosition().y != GPS.y) {
    		if(map.getLorannPos().x != GPS.x || map.getLorannPos().y != GPS.y) {
    			Lorann.setPosition(GPS);
    		}
    	}  	
    	
    }
    
    /** Game loop */
    @Override
    public void showLoop() {
    	while(1==1) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(this.Lorann.getSpell() != null) {
				this.Lorann.getSpell().loopMissile();
				this.getView().NotifyAllOser();
				this.Lorann.getSpell().move(this.getMap());
				this.getView().NotifyAllOser();
				if(this.Lorann.getPosition().x == this.Lorann.getSpell().getPosition().x) {
					if(this.Lorann.getPosition().y == this.Lorann.getSpell().getPosition().y) {
						this.spellTaken();
						this.getLorann().setSpell(null);
						this.getView().NotifyAllOser();
					}
				}
			}
			
			moveLorannGPS();
			
			this.Lorann.loopLorannFace();
			
			if(this.Arbarr != null ) {
				
				if(this.Arbarr.getPosition() != null) {
					int aXPos = this.Arbarr.getPosition().x;
					int aYPos = this.Arbarr.getPosition().y;
					
					Arbarr.move(getMap());
					
					if(aXPos == this.Lorann.getPosition().x) {
						if(aYPos == this.Lorann.getPosition().y) {
							this.KillPlayer();
				    		System.out.println("You got killed by Arbarr");
						}
			    	}
					
					if(this.getLorann().getSpell() != null) {
						if(aXPos == this.Lorann.getSpell().getPosition().x) {
							if(aYPos == this.Lorann.getSpell().getPosition().y) {
								this.Arbarr.setImageName("transp.png");
								try {
									this.Arbarr.loadImage();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								this.Arbarr = null;
								this.getView().NotifyAllOser();
								
								System.out.println("You killed Arbarr");
							}
				    	}
					}
					
				}
				
				
			}
			
			
			if(this.Cargyv != null) {
				
				if(this.Cargyv.getPosition() != null) {
					int aXPos = this.Cargyv.getPosition().x;
					int aYPos = this.Cargyv.getPosition().y;
					
					Cargyv.move(getMap());
					if(aXPos == this.Lorann.getPosition().x) {
						if(aYPos == this.Lorann.getPosition().y) {
							this.KillPlayer();
				    		System.out.println("You got killed by Cargyv");
						}
			    	}
					
					if(this.getLorann().getSpell() != null) {
						if(aXPos == this.Lorann.getSpell().getPosition().x) {
							if(aYPos == this.Lorann.getSpell().getPosition().y) {
								this.Cargyv.setImageName("transp.png");
								try {
									this.Cargyv.loadImage();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								this.Cargyv = null;
								this.getView().NotifyAllOser();
								
								System.out.println("You killed Cargyv");
							}
				    	}
					}
					
				}
				
			}
			
			
			if(this.Kyrac != null) {
				
				if(this.Kyrac.getPosition() != null) {
					int aXPos = this.Kyrac.getPosition().x;
					int aYPos = this.Kyrac.getPosition().y;
					
					Kyrac.move(getMap());
					if(aXPos == this.Lorann.getPosition().x) {
						if(aYPos == this.Lorann.getPosition().y) {
							this.KillPlayer();
				    		System.out.println("You got killed by Kyrac");
						}
			    	}
					
					if(this.getLorann().getSpell() != null) {
						if(aXPos == this.Lorann.getSpell().getPosition().x) {
							if(aYPos == this.Lorann.getSpell().getPosition().y) {
								this.Kyrac.setImageName("transp.png");
								try {
									this.Kyrac.loadImage();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								this.Kyrac = null;
								this.getView().NotifyAllOser();
								
								System.out.println("You killed Kyrac");
							}
				    	}
					}
					
				}
				
			}
			
			
			if(this.Maarcg != null) {
				
				if(this.Maarcg.getPosition() != null) {
					int aXPos = this.Maarcg.getPosition().x;
					int aYPos = this.Maarcg.getPosition().y;
					
					Maarcg.move(getMap());
					if(aXPos == this.Lorann.getPosition().x) {
						if(aYPos == this.Lorann.getPosition().y) {
							this.KillPlayer();
				    		System.out.println("You got killed by Maarcg");
						}
			    	}
					
					if(this.getLorann().getSpell() != null) {
						if(aXPos == this.Lorann.getSpell().getPosition().x) {
							if(aYPos == this.Lorann.getSpell().getPosition().y) {
								this.Maarcg.setImageName("transp.png");
								try {
									this.Maarcg.loadImage();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								this.Maarcg = null;
								this.getView().NotifyAllOser();
								
								System.out.println("You killed Maarcg");
							}
				    	}
					}
					
				}
				
			}
			
			this.isPlayerDead();
			this.getView().NotifyAllOser();
		}
    }
    
    /** Check if player is dead */
    private void isPlayerDead() {
    	if(!this.Lorann.isAlive()) {
    		
    	}
   }
    
   /** Add score */
   private void addScore(int score) {
	   this.Score += score;
   }
    
   /** Check if there are obstacle on the map */ 
   private int mapChecker(Element element, int x, int y) {
    	switch(element.getSprite()) {
    	case ' ':
    		return 0;
		case 'B':
			addScore(100);
			System.out.println(this.Score);
			itemTaken(x, y);
    		return 1;
		case 'N':
			nextLevel();
			return 2;
		case 'E':
			getKey();
			itemTaken(x, y);
			return 3;
		case 'D':
			return 4;
    	}
		return -1;
    }
    
    /** KeyListener */
    @Override
    public void keyPressedListener(KeyEvent e) {
    	switch(e.getKeyChar()) {
		case 'z':
			//MoveUp
			if(mapChecker(this.getMap().getElement(Lorann.getY()-1, Lorann.getX()), this.Lorann.getX(), this.Lorann.getY()-1) != -1) {
				Lorann.moveUp();
				this.getView().NotifyAllOser();
			}
			break;
		case 's':
			//MoveDown
			if(mapChecker(this.getMap().getElement(Lorann.getY()+1, Lorann.getX()), this.Lorann.getX(), this.Lorann.getY()+1) != -1) {
				Lorann.moveDown();	
				this.getView().NotifyAllOser();
			}
			break;
		case 'q':
			//MoveLeft
			if(mapChecker(this.getMap().getElement(Lorann.getY(), Lorann.getX()-1), this.Lorann.getX()-1, this.Lorann.getY()) != -1) {
				Lorann.moveLeft();	
				this.getView().NotifyAllOser();
			}
			break;
		case 'd':
			//MoveRight
			if(mapChecker(this.getMap().getElement(Lorann.getY(), Lorann.getX()+1), this.Lorann.getX()+1, this.Lorann.getY()) != -1) {
				Lorann.moveRight();	
				this.getView().NotifyAllOser();
			}
			break;
		case 'a':
			//MoveUpperLeft
			if(mapChecker(this.getMap().getElement(Lorann.getY()-1, Lorann.getX()-1), this.Lorann.getX()-1, this.Lorann.getY()-1) != -1) {
				Lorann.moveDir(-1, -1);
				this.getView().NotifyAllOser();
			}
			break;
		case 'e':
			//MoveUpperRight
			if(mapChecker(this.getMap().getElement(Lorann.getY()-1, Lorann.getX()+1), this.Lorann.getX()+1, this.Lorann.getY()-1) != -1) {
				Lorann.moveDir(1, -1);
				this.getView().NotifyAllOser();
			}
			break;
		case 'w':
			//MoveBottomLeft
			if(mapChecker(this.getMap().getElement(Lorann.getY()+1, Lorann.getX()-1), this.Lorann.getX()-1, this.Lorann.getY()+1) != -1) {
				Lorann.moveDir(-1, 1);
				this.getView().NotifyAllOser();
			}
			break;
		case 'c':
			//MoveBottomRight
			if(mapChecker(this.getMap().getElement(Lorann.getY()+1, Lorann.getX()+1), this.Lorann.getX()+1, this.Lorann.getY()+1) != -1) {
				Lorann.moveDir(1, 1);
				this.getView().NotifyAllOser();
			}
			break;
		case ' ':
			if(this.Lorann.getSpell() != null) {
				
			}else {
				this.Lorann.setSpell(this.Lorann.summonSpell());
				this.getView().getBoardFrame().addPawn(this.Lorann.getSpell());
				this.getView().NotifyAllOser();
			}
			break;
    	}
    	
    }

	/**
	 * @return the lorann
	 */
	public Lorann getLorann() {
		return Lorann;
	}

	/**
	 * @param lorann the lorann to set
	 */
	public void setLorann(Lorann lorann) {
		Lorann = lorann;
	}

	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	public static int getlevel() {
		
		int level = 0;
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("level.txt");
			br = new BufferedReader(fr);
			
			
			level =  Integer.parseInt(br.readLine());		
			} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		return level;
		
	}

}
