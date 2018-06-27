package model.element;

import java.awt.Point;

import showboard.IPawn;


/**
 * <h1>The Interface IMobile.</h1>
 */
public interface IMobile extends IPawn {

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();

	void setPosition(Point point);

	Missile summonSpell();

	int isDead(Boolean isAlive);

	void loopLorannFace();

	Point getDir();

	void setSpell(Missile spell);

	Missile getSpell();

	void moveDir(int x, int y);

}
