package application.model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import application.controller.LevelState;
import application.Utilities.Load;

public abstract class Entity {

    //Dimension and position
    protected int x, y;
    private int Width, Height;

    //Image
    private BufferedImage image;

    //Level State
    protected LevelState level;

    //Directions
    protected boolean right, left, up, down;

    //Speed
    protected int speed;

    /**
     * Creats a new Entity With a level
     *
     * @param level the entity to a level
     */
    public Entity(LevelState level) {
        this.level = level;
    }

    /**
     * Sets the x and y position of an eeity
     *
     * @param x The x position to set it to
     * @param y The y position to set it to
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /***
     * Sets the image for an entity
     * Updates width and height based on the image
     * @param image The image to set it too
     */
    public void setImage(BufferedImage image) {
        this.image = image;
        //Width and height is based on the image height and width
        Width = image.getWidth();
        Height = image.getHeight();
    }

    /***
     * Sets image of an entity with path instead of bufferedimage object
     * @param path The path of the image
     */
    public void setImage(String path) {
        setImage(Load.getImage(path));
    }

    /**
     * Sets an image to NULL
     * images can not be set to NULL using setImage because both methods can take NULL as an argument
     */
    public void nullImage() {
        this.image = null;
    }

    /**
     * Updats the entity
     */
    public void update() {
        getPosition();
    }

	/**
	 * Checks for an intersection between two entities
	 * @param e1 The first entity
	 * @param e2 The second entity
	 * @return Returns true if theirs an intersection and false otherwise
	 */
    public boolean intersection(Entity e1, Entity e2) {
        Rectangle r1 = e1.getRectangle();
        Rectangle r2 = e2.getRectangle();

        return (r1.intersects(r2));
    }

	/**
	 * Checks for an intersection between called entity and another entity
	 * @param e The other entity
	 * @return Returns true if theirs an intersection and false otherwise
	 */
    public boolean intersection(Entity e) {
    	return intersection(this, e);
    }


	/**
	 * Gets the height of an entity
	 * @return The height of the entity
	 */
	public int getHeight() {
        return Height;
    }

	/**
	 * Gets the width of an entity
	 * @return The width of an entity
	 */
	public int getWidth() {
        return Width;
    }

	/***
	 * Gets the rectangle object of an entity
	 * Based off the position and dimensions
	 * @return The rectnagle object
	 */
	public Rectangle getRectangle() {
        return new Rectangle(x, y, Width, Height);
    }

	/**
	 * Gets the image of the entity
	 * @return The image
	 */
	public BufferedImage getImage() {
        return image;
    }

	/**
	 * Get x position of entity
	 * @return The x position
	 */
	public int getX() {
        return x;
    }

	/***
	 * Gets y position of entity
	 * @return The y position
	 */
	public int getY() {
        return y;
    }

	/**
	 * Gets the position of the entity as a Point Object
	 * @return The point object
	 */
	public Point getPointPosition() {
        return new Point(x, y);
    }

	/***
	 * Draws the entities image at x and y
	 * @param g The graphcis context to draw with
	 */
	public void draw(GraphicsContext g) {
        g.drawImage(SwingFXUtils.toFXImage(this.image, null), x, y);
        //Draw hit box
        //g.drawRect(x, y, Width, Height);
    }

	/***
	 * Gets the position of an entity
	 */
	public void getPosition() {
        //Uses pixel movement
        if (right)
            x += speed;
        if (left)
            x -= speed;
        if (up)
            y -= speed;
        if (down)
            y += speed;
    }

	/***
	 * Gets the speed of an entity
	 * @return
	 */
	public int getSpeed() {
        return speed;
    }

	/***
	 * Sets the speed of an entity
	 * @param speed The speed to set it ot
	 */
	public void setSpeed(int speed) {
        this.speed = speed;
    }

	/***
	 * Sets the entity to be moving right
	 * @param right Sets right
	 */
	public void setRight(boolean right) {
        this.right = right;
    }

	/***
	 * Sets the entity to be moving left
	 * @param left If the entity should move left
	 */
	public void setLeft(boolean left) {
        this.left = left;
    }

	/***
	 * Sets the enttity to be moving up
	 * @param up If the entity should move up
	 */
	public void setUp(boolean up) {
        this.up = up;
    }

	/***
	 * Sets the entity Moving down
	 * @param down If the enetity should move down
	 */
	public void setDown(boolean down) {
        this.down = down;
    }


}
