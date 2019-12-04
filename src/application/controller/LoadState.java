package application.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import javafx.scene.canvas.GraphicsContext;
import application.Utilities.Load;

public class LoadState implements GameState {

	private GameStateManager gsm;

	private Background bg;

	/***
	 * Constructor for Load State
	 * @param gsm The game state manager
	 */
	public LoadState(GameStateManager gsm){
		this.gsm = gsm;
		try{
			BufferedImage bgImage = ImageIO.read(getClass().getResourceAsStream("/Default/Load.png"));
			bg = new Background(bgImage);
		} catch(Exception e){
			e.printStackTrace();
		}
		Load.loadData();
		gsm.changeState(GameStateManager.MENUSTATE);
	}

	/***
	 * Update funciton
	 */
	public void update(){}

	/***
	 * Used to draw the background
	 * @param g The graphics context to draw with
	 */
	public void draw(GraphicsContext g) {
		bg.draw(g);
	}

	public void keyPressed(int e) {}

	public void keyReleased(int e) {
		
	}

}
