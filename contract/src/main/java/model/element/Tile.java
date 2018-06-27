package model.element;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import showboard.ISquare;

public class Tile implements ISquare {

    /** The image. */
    private Image  image;

    /** The image name. */
    private String imageName;

    /**
     * Instantiates a new square.
     *
     * @param imageName the image name
     */
    public Tile(final String imageName) {
        this.setImageName(imageName);
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    /*
     * (non-Javadoc)
     * @see showboard.ISquare#getImage()
     */
    @Override
    public final Image getImage() {
        return this.image;
    }

    /**
     * Load image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("src/main/resources/" + getImageName())));
    }
    
    /**
     * Sets the image.
     *
     * @param image the new image
     */
    private void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Gets the image name.
     *
     * @return the image name
     */
    public String getImageName() {
        return this.imageName;
    }

    /**
     * Sets the image name.
     *
     * @param imageName the imageName to set
     */
    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }

}
