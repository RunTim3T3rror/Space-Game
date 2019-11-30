package application.Utilities;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Image {
	
	private BufferedImage image;

	private String name;
	
	public Image(String name){
		this("Default", name, ".png");
	}
	
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
	
	
	
	public String getName(){return name;}
	public BufferedImage getImage(){return image;}
}
