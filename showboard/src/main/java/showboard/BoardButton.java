package showboard;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoardButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ImageIcon for the button
	 */
	private ImageIcon icon;
	
	/**
	 * Emplacement of the button
	 */
	private GridBagConstraints gbc;
	
	/**
	 * X postion
	 */
	private int x;
	
	/**
	 * Y position
	 */
	private int y;
	
	/**
	 * Button's heigth
	 */
	private int heigth;
	
	/**
	 * Button's width
	 */
	private int width;
	
	/**
	 * JButton
	 */
	private JButton button;
		
	/**
	 * Initialize Button
	 * @param gbc {@link GridBagConstraints}
	 * @param icon {@link ImageIcon}
	 * @param x {@link Integer} 
	 * @param y {@link Integer} 
	 * @param heigth {@link Integer} 
	 * @param width {@link Integer} 
	 * @param button {@link JButton}
	 * @param actionListener {@link ActionListener}
	 */
	public BoardButton(GridBagConstraints gbc, ImageIcon icon, int x, int y, int heigth, int width, JButton button, ActionListener actionListener) {
		this.button = button;
		this.button.setIcon(icon);
		this.button.addActionListener(actionListener);
		this.icon = icon;
		this.gbc = gbc;
		this.x = x;
		this.y = y;
		this.heigth = heigth;
		this.width = width;
		setPreferredSize(new Dimension(width, heigth));
	}
	
	/**
	 * Initialize Grid
	 */
	public void initGBC() {
		this.gbc.gridx = this.x;
		this.gbc.gridy = this.y;
		this.gbc.gridheight = this.heigth;
		this.gbc.gridwidth = this.width;
	}
	
	/**
	 * @return JButton {@link JButton}
	 */
	public JButton getButton() {
		return this.button;
	}
	
	/**
	 * @return GridBagContraints {@link GridBagConstraints}
	 */
	public GridBagConstraints getGBC() {
		return this.gbc;
	}
	
	/**
	 * Set new GridBagConstraints
	 * @param gbc {@link GridBagConstraints}
	 */
	public void setGBC(GridBagConstraints gbc) {
		this.gbc = gbc;
	}
	
	/**
	 * Set new Icon
	 * @param icon {@link ImageIcon}
	 */
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	/**
	 * Get icon
	 * @return ImageIcon {@link ImageIcon}
	 */
	public ImageIcon getIcon() {
		return this.icon;
	}
	
	/**
	 * Set new x Position 
	 * @see GridBagConstraints#gridx
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Get x Position
	 * @see GridBagConstraints#gridx
	 * @return xPosition {@link Integer}
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Set new y Position
	 * @param y {@link Integer}
	 * @see GridBagConstraints#gridy
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Set new y Position
	 * @return yPosition {@link Integer}
	 * @see GridBagConstraints#gridy
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * 
	 * @param heigth {@link Integer}
	 */
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
	/**
	 * @return button's heigth {@link Integer}
	 */
	public int getHeigth() {
		return this.heigth;
	}
	
	/**
	 * @param width {@link Integer}
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @return button's width {@link Integer}
	 */
	public int getWidth() {
		return this.width;
	}
}