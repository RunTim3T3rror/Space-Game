package application.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;

import java.awt.image.BufferedImage;

public class Background {

	//Background image
	private BufferedImage bg;
	
	//Position
	private int x, y;

	/**
	 * Constructor for background which sets a buffered image for the background
	 * @param bg The buffered image to set
	 */
	public Background(BufferedImage bg){
		this.bg = bg;
	}

	/***
	 * Set position to draw the background
	 * @param x The x position to set it to
	 * @param y The y position to set it to
	 */
	public void setPosition(int x, int y){
		this.x  = x;
		this.y = y;
	}

	/**
	 * Update function for background
	 *
	 */
	public void update(){ }

	/***
	 * Draw function which draws the buffered image at the x and y positions
	 * @param g The graphics context to draw with
	 */
	public void draw(GraphicsContext g){
		g.drawImage( SwingFXUtils.toFXImage(bg, null), x, y);
	}

	/***
	 * Sets the x position of the background
	 * @param x The x position to set it to
	 */
	public void setX(int x){this.x = x;}

	/***
	 * Sets the y position of the background
	 * @param y The y position to set it to
	 */
	public void setY(int y){this.y = y;}

	/***
	 * Sets the background image
	 * @param bg The background image to set it to
	 */
	public void setBackground(BufferedImage bg) { this.bg = bg; }
	/***
	 * Gets the x position of the background
	 * @return The x position of the background
	 */
	public int getX(){return x;}

	/***
	 * Gets the y position of the background
	 * @return The y position of the background
	 */
	public int getY(){return y;}

	/**
	 * Gets the background image
	 * @return The background image
	 */
	public BufferedImage getBackground() { return bg; }
}
