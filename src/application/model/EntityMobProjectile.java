package application.model;

import java.util.ArrayList;

import application.controller.LevelState;
import application.Utilities.Load;

public class EntityMobProjectile extends Entity{

    public EntityMobProjectile(LevelState level){
        super(level);
        speed = 4;
        setImage(Load.getImage("Bullet"));
        this.setDown(true);
    }

    @Override
    public void update() {
        super.update();
        if (level.getPlayer().intersection(this)) {
            level.endGame();
        }
    }

}
