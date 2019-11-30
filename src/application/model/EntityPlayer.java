package application.model;

import java.util.ArrayList;

import application.Main;
import application.controller.LevelState;
import application.Utilities.Load;
import javafx.scene.canvas.GraphicsContext;

public class EntityPlayer extends Entity{
	
	private ArrayList<EntityProjectile> projectiles;
	
	private int fireTime;
	private boolean coolDown;
	
	public EntityPlayer(LevelState level) {
		super(level);
		setImage(Load.getImage("Player"));
		projectiles = new ArrayList<>();
		coolDown = false;

		fireTime = 0;
		speed = 2;
	}

	@Override
	public void update(){
		super.update();
		
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update();
		}

		if(fireTime > 50){
			fireTime = 0;
			coolDown = false;
		}
		else{
			fireTime++;
		}
	
	}
	
	public void fire(){
		if(coolDown) return;
		
		EntityProjectile projectile = new EntityProjectile(level);
		projectile.setPosition(this.x + 20, this.y - 10);
		projectiles.add(projectile);
		coolDown = true;
	}

	@Override
	public void getPosition() {
		if (right) {
			if (this.x >= Main.WIDTH - getImage().getWidth())
				this.setRight(false);
			else
				x += speed;
		}
		if (left) {
			if (this.x <= 0)
				this.setLeft(false);
			else
				x -= speed;
		}
	}

	@Override
	public void draw(GraphicsContext g){
		super.draw(g);
		
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).draw(g);
		}
	}
	
	public ArrayList<EntityProjectile> getProjectiles(){return projectiles;}
}
