package application.Utilities;

import java.awt.image.BufferedImage;

public class Sprite {
	
	//BufferdImage sprite
	private BufferedImage[] sprite;

	private BufferedImage bigImage;
	
	private int rows, cols;
	private int width, height;
	
	private String name;
	
	//Sprite's
	public static Sprite collisionSprite = new Sprite("CollisionSprite", 1, 3, 50, 50);
	public static Sprite mobSprite = new Sprite("MobSprite", 2, 3, 50, 50);
	
	/**
	 * Creates a sprite sheet
	 * @param path The path for the big image
	 * @param rows The amount of rows in the sprite
	 * @param cols The amount of columns in the sprite
	 * @param width The width of each sprite
	 * @param height The height of each sprite
	 */
	public Sprite(String name, int rows, int cols, int width, int height){
		this.rows = rows;
		this.cols = cols;
		this.width = width;
		this.height = height;		
		this.name = name;
		loadImages();
	}

	/**
	 * Loads images and the subImage for sprite[i(rows) * col) + j (cols))
	 */
	private void loadImages(){
		bigImage = Load.getImage(name);
		sprite = new BufferedImage[rows * cols];
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {

		        sprite[(i * cols) + j] = bigImage.getSubimage(
		            j * width,
		            i * height,
		            width,
		            height
		        );
		    }
		}
	}
	
	/**
	 * Gets the Buffered Image on the sprite sheet from a specific number
	 * @param num The specific number
	 * @return Returns the certain Buffered Image
	 */
	public BufferedImage getImage(int num){
			return sprite[num];
	}
	
	public BufferedImage getImage(int row, int col){
		int num;
		num = ((height * col) + (row * width)) - col;
		
		return getImage(num);
	}
	
}
