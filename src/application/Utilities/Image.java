package application.Utilities;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Image {
	
	private BufferedImage image;

	private String name;

	/**
	 * Creaats image in default folder with png as the type
	 * @param name Name of the image
	 */
	public Image(String name){
		this("Default", name, ".png");
	}

	/***
	 * Creats image in default folder with custom type
	 * @param name Name of the image
	 * @param type Type of the image
	 */
	public Image(String name, String type){
		this("Default", name ,type);
	}
	
	/**
	 * Allows for texture packs 
	 * @param folder The folder within recources
	 * @param name The name of the iage
	 * @param type The image type (ex. .png, .jpg , etc.)
	 */
	public Image(String folder, String name, String type){
		try{
			this.name = name;
			image = ImageIO.read(getClass().getResourceAsStream("/" + folder + "/" + name + type));
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Gets the name of the image
	 * @return The name of the image
	 */
	public String getName(){return name;}

	/**
	 * The buffered image
	 * @return the buffered image
	 */
	public BufferedImage getImage(){return image;}
}
