package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import controller.IController;
import model.element.Lorann;
import model.element.Monster;
import model.map.Map;
import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    
    void displayMap(Map map);
    
    void oldFrameConfigure(final BoardFrame frame, Map map);
    
    Map getMap();
    
    void setMap(Map map);

	ActionListener getActionListener();

	void setActionListener(ActionListener actionListener);

	KeyListener getKeyListener();

	void setKeyListener(KeyListener keyListener);

	void runWindow();

	void InitGameBoard(Map map);

	void setArbarr(Monster arbarr);

	void setCargyv(Monster cargyv);

	Monster getKyrac();

	void setKyrac(Monster kyrac);

	Monster getMaarcg();

	void setMaarcg(Monster maarcg);

	void setLorann(Lorann lorann);

	Lorann getLorann();

	void setController(IController controller);

	IController getController();

	BoardFrame getBoardFrame();

	void setBoardFrame(BoardFrame boardFrame);


	void NotifyAllOser();

	void isDoorOpen(boolean isOpen);

	void toBlank(int x, int y);

	void InitLevel(Map map);

}
