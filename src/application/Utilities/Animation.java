package application.Utilities;

import java.awt.image.BufferedImage;

public class Animation {

	private int currentImage;
	
	private Sprite sprite;
	
	private int delay;
	private int[] points;
	private int time;	

	//Animation's
	public static Animation explosion = new Animation(Sprite.collisionSprite, new int[] {0, 1, 2}, 1);

	/**
	 * Generates a animation which returns a different image after a certain delay
	 * @param sprite The sprite to get the images from 
	 * @param points The points from the sprite for the images (have to be in order 1st animation - final animation) 
	 * @param delay The delay between each image change
	 */
	public Animation(Sprite sprite, int[] points, int delay){
		this.sprite = sprite;
		this.points = points;
		this.delay = delay;
		currentImage = 0;
	}
	
	/**
	 * Allows static use of Animations in dynamic way
	 * @param animation The static Animation
	 */
	public Animation(Animation animation){
		this(animation.sprite, animation.points, animation.delay);
	}
	
	public void update(){
		time++;
		if(time == delay){
			time = 0;
			if(currentImage != points.length - 1)
				currentImage++;
			else
				currentImage = 0;
		}

	
	}
	
	//Getters
	public BufferedImage getImage(){return sprite.getImage(points[currentImage]);}
	public int getLength(){return points.length;}
	public int getCurrentImage(){return currentImage;}
	public Sprite getSprite(){return sprite;}
	public int[] getPoints(){return points;}
	public int getDelay(){return delay;}
}
