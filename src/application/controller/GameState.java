package application.controller;

import javafx.scene.canvas.GraphicsContext;

public interface GameState {
	
	public void update();
	public void draw(GraphicsContext g);
	public void keyPressed(int e);
	public void keyReleased(int e);
}
