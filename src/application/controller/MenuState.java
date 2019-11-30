package application.controller;

import java.awt.event.KeyEvent;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import application.Utilities.Load;

public class MenuState implements GameState{

	private GameStateManager gsm;

	private Background background;
	//Options
	private String[] options = {"Play", "Create Level", "Load Level", "Quit"};
	
	//Font
	private Font textFont;
	
	//Selected
	private int selected;
	
	public MenuState(GameStateManager gsm){
		this.gsm = gsm;
		textFont = new Font(74);
		selected = 0;
		background = new Background(Load.getImage("BackgroundMoving"));
	}

	public void update(){
		
	}
	
	

	public void draw(GraphicsContext g){
		g.setFill(Color.WHITE);
		g.fillRect(0, 0, 800, 600);
		background.draw(g);
		g.setFont(textFont);
		
		//Draw title
		g.fillText("Space Game", 200, 100);
		
		for(int i = 0; i < options.length; i++){
			if(selected == i) g.setFill(Color.RED);
			else 	g.setFill(Color.WHITE);
			g.fillText(options[i], 300, 200 + i * 90);
		}
		
	
	}
	
	public void keyPressed(int e){
		if(e == KeyEvent.VK_DOWN){
			if(selected != options.length - 1) selected++;
			else selected = 0;
		}
		if(e == KeyEvent.VK_UP){
			if(selected != 0) selected--;
			else selected = options.length - 1;
		}
		if(e == KeyEvent.VK_ENTER)
			select();
	}
	
	public void keyReleased(int e){
		
	}
	
	private void select(){
		if(selected == 0)
			gsm.changeState(GameStateManager.LEVELSTATE);
		else if (selected == 1)
			gsm.changeState(GameStateManager.CREATESTATE);
		else if (selected == 2)
			gsm.changeState(GameStateManager.CUSTOMSTATE);
		else if(selected == options.length - 1)
			System.exit(0);
	}
	
}

