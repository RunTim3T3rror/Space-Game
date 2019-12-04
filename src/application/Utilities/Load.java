package application.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.HashMap;

import application.controller.GameStateManager;


public class Load {

	//Image and sound
	private static HashMap<String, Image> images = new HashMap<>();
	
	//Game State Manager
	public static GameStateManager gsm;

	/***
	 * Loads image and all static data in certain class'
	 */
	public static void loadData(){
		loadImages();
		loadClasses();
	}

	/***
	 * Loads the global game state manager
	 */
	public static void loadGsm(){
		gsm = new GameStateManager();
	}

	/***
	 * Loads all images into hashmap
	 */
	private static void loadImages(){
		images.put("Player", new Image("Player"));
		images.put("Bullet", new Image("Bullet"));
		images.put("CollisionSprite", new Image("CollisionSprite"));
		images.put("MobSprite", new Image("MobSprite"));
		images.put("BackgroundMoving", new Image("BackgroundMoving"));
		images.put("LevelOne", new Image("LevelOne"));
		images.put("LevelTwo", new Image("LevelTwo"));
		images.put("LevelThree", new Image("LevelThree"));
		images.put("LevelFour", new Image("LevelFour"));
		images.put("LevelFive", new Image("LevelFive"));
		images.put("LevelSix", new Image("LevelSix"));
		images.put("CustomLevel", new Image("CustomLevel"));
		images.put("Boss", new Image("Boss"));
	}

	/***
	 * loads the static objects in Sprite animation and levels classes
	 */
	private static void loadClasses(){
		try {
			Class.forName("application.Utilities.Sprite");
			Class.forName("application.Utilities.Animation");
			Class.forName("application.controller.Levels");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	/***
	 * Gets an image from the hashmap
	 * If the image is not found in the hashmap it attempts to find the image in default folder
	 * @param name The name of the image
	 * @return The buffered image that was found
	 */
	public static BufferedImage getImage(String name){
		if (images.containsKey(name))
			return images.get(name).getImage();
		
		//Backup code should never be used
		System.err.println("Could not find in first image search");
		System.err.println("Trying to add Image to the images List");
		images.put(name, new Image(name));
		BufferedImage image = getImage(name);
		if(image == null) return null;
		return image;
	
	}

	/***
	 * Masks an image in all red
	 * Sets all pixel values of an image (that aren't transparent) to have full red rgb
	 * @param originalImage The original image
	 * @return A copy of the original image with all red mask
	 */
	public static BufferedImage maskImage(BufferedImage originalImage) {

		ColorModel cm = originalImage.getColorModel();
		boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		WritableRaster raster = originalImage.copyData(null);
		BufferedImage image = new BufferedImage(cm, raster, isAlphaPremultiplied, null);

		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				Color original = new Color(image.getRGB(x, y));
				int pixel = image.getRGB(x,y);
				if( (pixel>>24) == 0x00 ) {
					continue;
				}
				Color mask = new Color(255, original.getGreen(), original.getBlue());
				image.setRGB(x, y, mask.getRGB());
			}
		}

		return image;
	}
}
