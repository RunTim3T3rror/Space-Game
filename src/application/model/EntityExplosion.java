package application.model;

import application.controller.LevelState;
import application.Utilities.Animation;

public class EntityExplosion extends Entity {
	
	private Animation animation;
	
	private Entity attachedEntity;

	/***
	 * Constructor for entity explosion
	 * @param level The level state
	 * @param attachedEntity The entity where the explosion will appear
	 */
	public EntityExplosion(LevelState level, Entity attachedEntity){
		super(level);
		this.attachedEntity = attachedEntity;
		x = attachedEntity.x;
		y = attachedEntity.y;
		animation = new Animation(Animation.explosion);
		setImage(animation.getImage());
	}

	/***
	 * Updates the explosion animation
	 * Removes attached entity once explosion animation finishes
	 */
	@Override
	public void update() {
		super.update();
		animation.update();
		
		if(animation.getCurrentImage() + 1 == animation.getLength()){
			if(attachedEntity != null)
				level.getMobs().remove(attachedEntity);
		}
		
	}
}
