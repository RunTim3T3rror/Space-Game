package application.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import javafx.scene.canvas.GraphicsContext;
import application.Utilities.Load;

public class LoadState implements GameState {

	private GameStateManager gsm;

	private Background bg;
	
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
	
	public void update(){}

	public void draw(GraphicsContext g) {
		bg.draw(g);
	}

	public void keyPressed(int e) {}

	public void keyReleased(int e) {
		
	}

}
