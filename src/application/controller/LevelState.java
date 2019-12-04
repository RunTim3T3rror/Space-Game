package application.controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import application.Main;
import application.model.*;
import javafx.scene.canvas.GraphicsContext;
import application.Utilities.Load;

public class LevelState implements GameState {

	// Entities
	protected ArrayList<EntityMob> mobs;
	protected ArrayList<Entity> entities;
	protected EntityPlayer player;
	protected Point playerPos;

	// Map
	private BufferedImage map;

	//Background
	protected Background background;

	/***
	 * Creats a levelstate based on a given bufferedimage map
	 * @param map The map to construct the level off of
	 */
	public LevelState(BufferedImage map) {
		this.map = map;
		background = getBackground();
		
		createEntities();
	}
	
	/**
	 * Creates all the entities for the game
	 * Reads the map to place the mobs and player
	 */
	private void createEntities() {
		player = new EntityPlayer(this);
		mobs = new ArrayList<>();
		entities = new ArrayList<>();

		/**
		 * probably should make a map reader class shouldn't be in the
		 * LevelState
		 */
		for (int x = 0; x < Main.WIDTH / 50; x++) {
			for (int y = 0; y < Main.HEIGHT / 50; y++) {
				Color c = new Color(map.getRGB(x, y));
				if (c.getBlue() == 255 && c.getRed() == 0
						&& c.getGreen() == 0) {
					EntitySimple mob = new EntitySimple(this);
					mob.setPosition(x * 50, y * 50);
					mobs.add(mob);
				}

				if (c.getBlue() == 255 && c.getRed() == 255
						&& c.getGreen() == 0) {
					EntityBoss mob = new EntityBoss(this);
					mob.setPosition(x * 50, y * 50);
					mobs.add(mob);
				}
				if(c.getRed() == 0 &&c.getBlue() == 0 && c.getGreen() == 255){
					EntityInvisible mob = new EntityInvisible(this);
					mob.setPosition(x * 50, y * 50);
					mobs.add(mob);
				}


				// Detected player
				if (c.getRed() == 255 && c.getBlue() == 0
						&& c.getGreen() == 0) {
					playerPos = new Point(x * 50,  y * 50);

					player.setPosition(playerPos.x, playerPos.y);
				}
			}
		}

	}

	/***
	 * Removs an EntityMov from the level state at a given index
	 * @param id The index to remove
	 */
	public void removeMob(int id) {
		mobs.remove(id);
	}

	/***
	 * Updates all entities
	 * Checks if the level is ended
	 */
	public void update() {
		updateMobs();
		checkEnd();
		//spawnItems();
	}

	/**
	 * Updates all the mobs om the levelstate
	 */
	private void updateMobs() {
		player.update();
		update(entities);
		update(mobs);
	}

	/**
	 * Checks if mob size is 0 (all mobs dead) and calls win function
	 * checks if mobs are under player of if intersect player and call lose function
	 */
	private void checkEnd() {
		if (mobs.size() == 0)
			onWin();

		int playerY = playerPos.y;

		for (int i = 0; i < mobs.size(); i++) {
			EntityMob mob = mobs.get(i);
			if (mob.intersection(player) || mob.getY() > playerY)
				endGame();
		}

	}

	/***
	 * Updates all entities
	 * @param e
	 */
	private void update(ArrayList<?> e) {
		for (int i = 0; i < e.size(); i++) {
			Entity entity = (Entity) e.get(i);
			entity.update();
		}
		
	}

	/***
	 * The function called when the player defeated all mobs
	 * If last level go to win state
	 */
	private void onWin() {
		if (Levels.currentLevel == Levels.levelSix.getLevelState()) {
			Load.gsm.changeState(GameStateManager.WONSTATE);
			return;
		}
		Load.gsm.changeState(GameStateManager.LEVELSTATE);
		createEntities();
	}

	/***
	 * Function called when the player died
	 */
	public void endGame() {
		Load.gsm.changeState(GameStateManager.LOSTSTATE);
		createEntities();
	}

	/***
	 * Draw function for the level
	 * draws all entities
	 * @param g The graphics context to draw with
	 */
	public void draw(GraphicsContext g) {
		g.clearRect(0, 0, 800, 600);
		background.draw(g);
		player.draw(g);
		draw(mobs, g);
		draw(entities, g);
	}

	/***
	 * Draws entities
	 * @param entities Entities to draw
	 * @param g Graphics context to draw with
	 */
	private void draw(ArrayList<?> entities, GraphicsContext g) {
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = (Entity) entities.get(i);
			entity.draw(g);
		}
	}

	/***
	 * Called when key is pressed
	 * @param k The key code of the pressed key
	 */
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_RIGHT)
			player.setRight(true);
		if (k == KeyEvent.VK_LEFT)
			player.setLeft(true);
		if (k == KeyEvent.VK_F)
			player.fire();
		if(k == KeyEvent.VK_D)
			onWin();
		if (k == KeyEvent.VK_BACK_SPACE) {
			Load.gsm.currentLevel = 0;
			createEntities();
			Load.gsm.changeState(GameStateManager.MENUSTATE);
		}
	}

	/***
	 * Called when key is released
	 * @param k The code of the released key
	 */
	public void keyReleased(int k) {
		if (k == KeyEvent.VK_RIGHT)
			player.setRight(false);
		if (k == KeyEvent.VK_LEFT)
			player.setLeft(false);
	}


	/***
	 * Returns the player of the level
	 * @return The entity player object
	 */
	public EntityPlayer getPlayer() {
		return player;
	}

	/***
	 * Returns all mobs in the game
	 * @return ArrayList of all mobs
	 */
	public ArrayList<EntityMob> getMobs() {
		return mobs;
	}

	/***
	 * Returns the background of the levelstate
	 * @return The Background object
	 */
	protected Background getBackground(){
		return new Background(Load.getImage("BackgroundMoving"));
	}

	/***
	 * Returns all entities in the game
	 * @return
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}

}
