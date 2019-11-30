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

	public Levels(LevelState levelState){
		this.levelState = levelState;
		id = maxId;
		maxId++;
		levels.add(this);
	}

	public int getId(){return id;}
	public LevelState getLevelState(){return levelState;}
	
	public static Levels getLevel(int id){
		for(int i = 0; i < levels.size(); i++){
			if(id == levels.get(i).id) return levels.get(i);
		}
		
		return null;
	}
	
}