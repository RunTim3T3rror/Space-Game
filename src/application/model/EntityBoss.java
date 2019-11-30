package application.model;

import application.Utilities.Load;
import application.controller.LevelState;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Random;

public class EntityBoss extends EntityMob {


    private ArrayList<EntityMobProjectile> projectiles;

    private int nextShot;
    private int shotTime;

    public EntityBoss(LevelState level) {
        super(level);
        setImage(Load.getImage("Boss"));
        speed = 2;
        health = 20;
        shotTime = 0;
        nextShot = new Random().nextInt((100 - 70) + 1) + 70;
        projectiles = new ArrayList<>();
    }

    @Override
    public void update(){
        super.update();
        for(int i = 0; i < projectiles.size(); i++){
            projectiles.get(i).update();
        }

        shotTime++;
        if (shotTime >= nextShot) {
            this.fire();
            shotTime = 0;
            nextShot = new Random().nextInt((50 - 30) + 1) + 30;
        }
    }

    private void fire(){
        EntityMobProjectile projectile = new EntityMobProjectile(level);
        projectile.setPosition(this.x + 50, this.y + 100);
        projectiles.add(projectile);
    }



    @Override
    public void draw(GraphicsContext g){
        super.draw(g);

        for (int i = 0; i < projectiles.size(); i++){
            projectiles.get(i).draw(g);
        }
    }
}
