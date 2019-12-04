package application.model;

import application.Main;
import application.Utilities.Load;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import application.controller.LevelState;

public class EntityMob extends Entity {

	protected int health;
	protected boolean dead, invincible, hit;

	private EntityExplosion explosion;

	// Time
	private int time;
	private int maxTime;
	private int hitTime;
	private int hitMaxTime;
	private int nextDown;

	/***
	 * Constructor for entity mob
	 * @param level
	 */
	public EntityMob(LevelState level) {
		super(level);
		speed = 2;
		health = 3;
		maxTime = 100;
		time = -1;
		hitTime = 0;
		hitMaxTime = 10;
		nextDown = -1;
		invincible = false;
	}

	/***
	 * Default Mob AI for all Entity Mob
	 * Moves entity back and forth randomly
	 */
	protected void mobAI() {
		// Horizontal
		double rand = Math.random() * 2;
		rand = (int) rand;

		if (time == maxTime || time == -1) {
			if (rand == 0) {
				this.setLeft(false);
				this.setRight(true);
			} else if (rand == 1) {
				this.setRight(false);
				this.setLeft(true);
			}
		}

		if (this.x < 0) {
			this.setLeft(false);
			this.setRight(true);
		} else if (this.x > Main.WIDTH - this.getImage().getWidth()) {
			this.setRight(false);
			this.setLeft(true);
		}

		// Vertical
		if (time > maxTime) {
			nextDown++;
			if (nextDown == 10) {
				nextDown = -1;
				time = 0;
			}
			this.y++;
		}
		if (hitTime > hitMaxTime) {
			hit = false;
			hitTime = 0;
		}
	}

	/***
	 * Creates an entity explosion if the entity mob was killed
	 */
	public void checkHealth() {
		if (health < 0 || health == 0) {
			dead = true;
			explosion = new EntityExplosion(level, this);
		}

	}

	/***
	 * Updates the mob
	 */
	@Override
	public void update() {
		if (dead) {
			explosion.update();
			return;
		}
		super.update();
		mobAI();
		time++;
		checkHealth();
	}

	/***
	 * Draws the mob
	 * Draws a red mask over the mob if the mob was hit
	 * @param g The graphcis context to draw with
	 */
	@Override
	public void draw(GraphicsContext g) {
		if (dead) {
			explosion.draw(g);
			return;
		}
		if (hit) {
			hitTime++;
			g.drawImage(SwingFXUtils.toFXImage(Load.maskImage(this.getImage()), null), x, y);
			return;
		}
		g.drawImage(SwingFXUtils.toFXImage(this.getImage(), null), x, y);
	}

	/***
	 * Sets if the mob was hit
	 * @param hit If the mob was hit
	 */
	public void setHit(boolean hit){ this.hit = hit; }
}
