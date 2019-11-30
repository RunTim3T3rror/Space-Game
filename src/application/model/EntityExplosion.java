package application.model;

import application.controller.LevelState;
import application.Utilities.Animation;

public class EntityExplosion extends Entity {
	
	private Animation animation;
	
	private Entity attachedEntity;
	
	public EntityExplosion(LevelState level, Entity attachedEntity){
		super(level);
		this.attachedEntity = attachedEntity;
		x = attachedEntity.x;
		y = attachedEntity.y;
		animation = new Animation(Animation.explosion);
		setImage(animation.getImage());
	}
	
	
	public EntityExplosion(LevelState level){
		super(level);
		animation = Animation.explosion;
		setImage(animation.getImage());
	}
	
	@Override
	public void update() {
		super.update();
		animation.update();

		setImage(animation.getImage());
		
		
		if(animation.getCurrentImage() + 1 == animation.getLength()){
			if(attachedEntity != null)
				level.getMobs().remove(attachedEntity);
		}
		
	}
}
