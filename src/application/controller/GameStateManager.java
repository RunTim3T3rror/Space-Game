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
	
	public GameStateManager(){
		gameState = new GameState[MAXGAMESTATES];
		currentState = LOADSTATE;
		loadState(currentState);
	}
	
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
	
	private LevelState getLevelState(){
		LevelState level = Levels.getLevel(currentLevel).getLevelState();
		Levels.currentLevel = level;
		currentLevel++;
		return level;
	}
	
	public void changeState(int state){
		gameState[currentState] = null;
		currentState = state;
		
		loadState(state);
	}

	
	public void update(){
		try{			
			gameState[currentState].update();
		} catch(Exception e){}
	}
	
	public void draw(GraphicsContext g){
		try{
			gameState[currentState].draw(g);			
		} catch(Exception e){}
	}
	
	public void keyPressed(int e){
		try{
			gameState[currentState].keyPressed(e);			
		} catch(Exception k){}
	}
	
	public void keyReleased(int e){
		try{
			gameState[currentState].keyReleased(e);			
		} catch(Exception k){}
	}
	
	public GameState getCurrentState(){
		return gameState[currentState];
	}
	
	public void setCurrentLevel(int currentLevel){
		this.currentLevel = currentLevel;
	}
	
}
