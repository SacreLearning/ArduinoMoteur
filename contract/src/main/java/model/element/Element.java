package model.element;

public abstract class Element extends Tile {

	/** The sprite. */
    private char sprite;
    private Tile tile;

    /**
     * Instantiates a new element.
     *
     * @param sprite {@link Character}
     * @param tile {@link Tile}
     */
    public Element(final char sprite, final String tile) {
    	super(tile);
        this.setSprite(sprite);
    }

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    public final char getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite {@link Character}
     *            the new sprite
     */
    private void setSprite(final char sprite) {
        this.sprite = sprite;
    }

	/**
	 * @return the tile
	 */
	public Tile getTile() {
		return tile;
	}

	/**
	 * @param tile {@link Tile}
	 */
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
}
