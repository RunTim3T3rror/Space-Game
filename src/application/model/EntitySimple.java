package application.model;

import application.controller.LevelState;
import application.Utilities.Sprite;

public class EntitySimple extends EntityMob{

	/***
	 * Constructor for entity simple
	 * @param level The current level
	 */
	public EntitySimple(LevelState level) {
		super(level);
		setImage(Sprite.mobSprite.getImage(0, 0));
		speed = 2;
		health = 2;
	}

}
