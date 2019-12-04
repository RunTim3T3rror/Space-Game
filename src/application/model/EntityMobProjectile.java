package application.model;

import java.util.ArrayList;

import application.controller.LevelState;
import application.Utilities.Load;

public class EntityMobProjectile extends Entity{

    /**
     * Constructor for the mob projetile
     * @param level The current level
     */
    public EntityMobProjectile(LevelState level){
        super(level);
        speed = 4;
        setImage(Load.getImage("Bullet"));
        this.setDown(true);
    }

    /**
     * Updates the projectile
     * Checks if projectile hit player if so game ends
     */
    @Override
    public void update() {
        super.update();
        if (level.getPlayer().intersection(this)) {
            level.endGame();
        }
    }

}
