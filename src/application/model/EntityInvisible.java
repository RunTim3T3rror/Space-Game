package application.model;

import javafx.scene.canvas.GraphicsContext;
import application.controller.LevelState;
import application.Utilities.Sprite;

public class EntityInvisible extends EntityMob{

	//Time
	private int time, maxTime;

	
	public EntityInvisible(LevelState level){
		super(level);
		setImage(Sprite.mobSprite.getImage(1));
		speed = 1;
		health = 3;
		maxTime = 200;
		time = -1;
	}
	
	@Override
	public void update() {
		super.update();
		time++;
	}
	
	@Override
	protected void mobAI() {
		super.mobAI();

		if(time > maxTime){
			invincible = !invincible;
			setImage(Sprite.mobSprite.getImage(invincible ? 2 : 1));
			time = 0;
		}		
	}
}
