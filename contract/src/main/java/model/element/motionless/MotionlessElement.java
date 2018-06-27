package model.element.motionless;

import model.element.Element;

public abstract class MotionlessElement extends Element {

    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     */
    MotionlessElement(final char sprite, final String tile) {
        super(sprite, tile);
    }

}
