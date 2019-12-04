package application.controller;

import application.Utilities.Load;
import javafx.scene.canvas.GraphicsContext;

public class GameStateManager implements GameState {

	private int currentState;
	private GameState[] gameState;

	
	//GameStates
	private static int MAXGAMESTATES = 7;
	public static int LOADSTATE = 0;
	public static int MENUSTATE = 1;
	public static int LOSTSTATE = 2;
	public static int LEVELSTATE = 3;
	public static int CREATESTATE = 4;
	public static int CUSTOMSTATE = 5;
	public static int WONSTATE = 6;

	//current Level
	public int currentLevel = 0;

	/***
	 * Construcor for the game state manager
	 * Sets the current game state to the load state
	 */
	public GameStateManager(){
		gameState = new GameState[MAXGAMESTATES];
		currentState = LOADSTATE;
		loadState(currentState);
	}

	/***
	 * determines which game state (class) should be used for a given gamestate code
	 * @param state The game state code (use above static integers)
	 */
	private void loadState(int state){
		if(state == MENUSTATE) 
			gameState[currentState] = new MenuState(this);
		if(state == LOADSTATE)
			gameState[currentState] = new LoadState(this);
		if(state == LEVELSTATE)
			gameState[currentState] = getLevelState();
		if(state == LOSTSTATE)
			gameState[currentState] = new LostState(this);
		if(state == CREATESTATE)
			gameState[currentState] = new CreateState(this);
		if(state == CUSTOMSTATE)
			gameState[currentState] = new LevelState(Load.getImage("CustomLevel"));
		if (state == WONSTATE)
			gameState[currentState] = new WonState(this);
	}

	/***
	 * Gets the levelstate from a current level
	 * @return The levelState
	 */
	private LevelState getLevelState(){
		LevelState level = Levels.getLevel(currentLevel).getLevelState();
		Levels.currentLevel = level;
		currentLevel++;
		return level;
	}

	/***
	 * Changes the state based on a given state code
	 * @param state The state code
	 */
	public void changeState(int state){
		gameState[currentState] = null;
		currentState = state;
		
		loadState(state);
	}


	/***
	 * Updates the current gamestate
	 */
	public void update(){
		try{			
			gameState[currentState].update();
		} catch(Exception e){}
	}

	/***
	 * Draws the current gamestate
	 * @param g The graphics context to draw with
	 */
	public void draw(GraphicsContext g){
		try{
			gameState[currentState].draw(g);			
		} catch(Exception e){}
	}

	/***
	 * Calls keypressed for the current gamestate
	 * @param e The key code of the pressed key
	 */
	public void keyPressed(int e){
		try{
			gameState[currentState].keyPressed(e);			
		} catch(Exception k){}
	}

	/***
	 * Calls keyreleased for the current game state
	 * @param e  The key code of the released key
	 */
	public void keyReleased(int e){
		try{
			gameState[currentState].keyReleased(e);			
		} catch(Exception k){}
	}

	/***
	 * Returns the current game state
	 * @return The current game state
	 */
	public GameState getCurrentState(){
		return gameState[currentState];
	}

	/***
	 * Sets the current level
	 * @param currentLevel The current level to set it to
	 */
	public void setCurrentLevel(int currentLevel){
		this.currentLevel = currentLevel;
	}
	
}
