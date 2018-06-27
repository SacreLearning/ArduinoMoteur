package model.element;

import java.awt.Point;
import java.io.IOException;
import java.util.Random;

import model.IA.IMonster;
import model.map.Map;
import showboard.IPawn;

public class Item extends Tile implements IPawn {
	
	/** The position. */
    private Point	position;

    /** The random. */
    public final Random random = new Random();

    /**
     * Instantiates a new monster.
     *
     * @param imageName {@link String}
     * @param x the x
     * @param y the y
     */
    public Item(final String imageName, int x, int y) {
        super(imageName);
        try {
			this.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.setPosition(x, y);
    }

    /*
     * (non-Javadoc)
     * @see showboard.IPawn#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /*
     * (non-Javadoc)
     * @see showboard.IPawn#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /*
     * (non-Javadoc)
     * @see showboard.IPawn#getPosition()
     */
    @Override
    public final Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public final void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Sets the position.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public final void setPosition(final int x, final int y) {
        this.position = new Point(x, y);
    }


}
