package application.controller;

import java.util.ArrayList;

import application.Utilities.Load;

public class Levels {

	//Global variables
	private static ArrayList<Levels> levels = new ArrayList<Levels>();
	private static int maxId = 0;
	
	//Identification
	private int id;
	private LevelState levelState;
	
	//Current Level
	public static LevelState currentLevel;
	

	//Levels
	public static Levels LevelOne = new Levels(new LevelState(Load.getImage("LevelOne")));
	public static Levels levelTwo = new Levels(new LevelState(Load.getImage("LevelTwo")));
	public static Levels levelThree = new Levels(new LevelState(Load.getImage("LevelThree")));
	public static Levels levelFour = new Levels(new LevelState(Load.getImage("LevelFour")));
	public static Levels levelFive = new Levels(new LevelState(Load.getImage("LevelFive")));
	public static Levels levelSix = new Levels(new LevelState(Load.getImage("LevelSix")));

	/***
	 * Constructor for the levels
	 * Sets the id for each level
	 * @param levelState The current level state
	 */
	public Levels(LevelState levelState){
		this.levelState = levelState;
		id = maxId;
		maxId++;
		levels.add(this);
	}

	/***
	 * Gets the id for a level
	 * @return The id of a level
	 */
	public int getId(){return id;}

	/***
	 * Get the level state a levels uses
	 * @return Returns the level state
	 */
	public LevelState getLevelState(){return levelState;}

	/***
	 * Gets a level based on an id
	 * @param id The id to search for
	 * @return Returns the levels
	 */
	public static Levels getLevel(int id){
		for(int i = 0; i < levels.size(); i++){
			if(id == levels.get(i).id) return levels.get(i);
		}
		
		return null;
	}
	
}