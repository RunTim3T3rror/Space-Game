package application.controller;

import javafx.scene.canvas.GraphicsContext;

public interface GameState {

	/***
	 * The update function for a gamestate
	 * Called every frame
	 */
	public void update();

	/***
	 * The draw funtion for a gamestate
	 * Called every frame
	 * @param g The graphics context to draw with
	 */
	public void draw(GraphicsContext g);

	/***
	 * The keypressed function for a gamestate
	 * Called when key is pressed
	 * @param e The key code of the pressed key
	 */
	public void keyPressed(int e);

	/***
	 * The key released function for a gamestate
	 * Called when key is released
	 * @param e  The key code of the released key
	 */
	public void keyReleased(int e);
}
