package application.model;

import java.util.ArrayList;

import application.controller.LevelState;
import application.Utilities.Load;

public class EntityProjectile extends Entity{

	protected EntityPlayer player;
	protected ArrayList<EntityMob> mobs;
	
	protected int damage;
	protected int fireRate;

	/***
	 * Constructor for projectile
	 * @param level The current level
	 */
	public EntityProjectile(LevelState level){
		super(level);
		player = level.getPlayer();
		mobs = level.getMobs();
		fireRate = 10;
		speed = 4;
		setImage(Load.getImage("Bullet"));
		this.setUp(true);
	}

	/***
	 * Updates the projectile
	 * Checks if the projectile hit any mobs in the level
	 * removes projectile and decreases mob health if hit
	 */
	@Override
	public void update() {
		super.update();
		for(int i = 0; i < level.getMobs().size(); i++){
			if(level.getMobs().get(i).intersection(this)) {
				if (!level.getMobs().get(i).invincible) {
					level.getMobs().get(i).health--;
					level.getMobs().get(i).setHit(true);
					level.getPlayer().getProjectiles().remove(this);
				}
			}
		}
	}
}
