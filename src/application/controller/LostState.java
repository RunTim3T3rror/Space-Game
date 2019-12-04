package application.controller;

import application.Main;
import application.Utilities.Load;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.event.KeyEvent;

public class LostState  implements GameState{
	
	//GameStateManager
	private GameStateManager gsm;

	//Fonts
	private Font textFont, titleFont;
	private Background background;

	/***
	 * Constructor for lost sate
	 * Creates backgrounds
	 * Sets fonts
	 * @param gsm The game state manger
	 */
	public LostState(GameStateManager gsm){
		this.gsm = gsm;
		
		textFont = new Font(74);
		titleFont = new Font(100);
		background = new Background(Load.getImage("BackgroundMoving"));
		gsm.setCurrentLevel(0);
	}
	
	public void update(){}

	/**
	 * Used to draw the text and background to the screen
	 * @param g The graphics context to draw with
	 */
	public void draw(GraphicsContext g){
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
		background.draw(g);
		//Draw Title
		g.setFill(Color.WHITE);
		g.setFont(titleFont);
		g.fillText("You Lost.", 175, 150);

		//Draw Text
		g.setFont(textFont);
		g.fillText("Press Enter to go to", 100, 250);
		g.fillText("the main menu.", 100, 330);
	}

	/***
	 * Used to move between screens
	 * @param k The keycode of the pressed key
	 */
	public void keyPressed(int k){
		if(k == KeyEvent.VK_ENTER)
			gsm.changeState(GameStateManager.MENUSTATE);
		if(k == KeyEvent.VK_ESCAPE)
			System.exit(0);
	}
	
	public void keyReleased(int k){ }
	
}


