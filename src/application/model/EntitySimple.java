package application.model;

import application.controller.LevelState;
import application.Utilities.Sprite;

public class EntitySimple extends EntityMob{

	public EntitySimple(LevelState level) {
		super(level);
		setImage(Sprite.mobSprite.getImage(0, 0));
		speed = 2;
		health = 2;
	}

}
