package application.model;

import javafx.scene.canvas.GraphicsContext;
import application.controller.LevelState;
import application.Utilities.Sprite;

public class EntityInvisible extends EntityMob{

	//Time
	private int time, maxTime;

	/***
	 * Constructor for entity invisible
	 * @param level The current level
	 */
	public EntityInvisible(LevelState level){
		super(level);
		setImage(Sprite.mobSprite.getImage(1));
		speed = 1;
		health = 3;
		maxTime = 200;
		time = -1;
	}

	/**
	 * Update function
	 * increases time
	 */
	@Override
	public void update() {
		super.update();
		time++;
	}

	/***
	 * AI sets mob to invincible everytime time exceeds max time
	 */
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
