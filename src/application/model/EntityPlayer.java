package application.model;

import java.util.ArrayList;

import application.Main;
import application.controller.LevelState;
import application.Utilities.Load;
import javafx.scene.canvas.GraphicsContext;

public class EntityPlayer extends Entity{
	
	private ArrayList<EntityProjectile> projectiles;
	
	private int fireTime;
	private boolean coolDown;

	/***
	 * Constructor for the player
	 * @param level The current level
	 */
	public EntityPlayer(LevelState level) {
		super(level);
		setImage(Load.getImage("Player"));
		projectiles = new ArrayList<>();
		coolDown = false;

		fireTime = 0;
		speed = 2;
	}

	/***
	 * Updates the player
	 * Updates projectiles player has shot
	 */
	@Override
	public void update(){
		super.update();
		
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update();
		}

		if(fireTime > 50){
			fireTime = 0;
			coolDown = false;
		}
		else{
			fireTime++;
		}
	
	}

	/**
	 * Fires a shot if the players cooldown is false
	 */
	public void fire(){
		if(coolDown) return;
		
		EntityProjectile projectile = new EntityProjectile(level);
		projectile.setPosition(this.x + 20, this.y - 10);
		projectiles.add(projectile);
		coolDown = true;
	}

	/**
	 * Sets the players position
	 * Constrains the player in the window
	 */
	@Override
	public void getPosition() {
		if (right) {
			if (this.x >= Main.WIDTH - getImage().getWidth())
				this.setRight(false);
			else
				x += speed;
		}
		if (left) {
			if (this.x <= 0)
				this.setLeft(false);
			else
				x -= speed;
		}
	}

	/***
	 * Draws the player
	 * Draws all the projectiles the player has shot
	 * @param g The graphcis context to draw with
	 */
	@Override
	public void draw(GraphicsContext g){
		super.draw(g);
		
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).draw(g);
		}
	}

	/***
	 * Gets the arraylist of the projectiles
	 * @return The arralist of projectiles
	 */
	public ArrayList<EntityProjectile> getProjectiles(){return projectiles;}
}
