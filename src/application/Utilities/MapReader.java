package application.Utilities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MapReader {
	
	private BufferedImage map;
	
	private ArrayList<Color> colors;
	
	
	//Colors
	public static int GREEN = 0;
	public static int BLUE = 1;
	public static int RED = 2;
	
	public MapReader(BufferedImage map){
		this.map = map;
	}
	

	public void loadColors(int seperator){
		colors = new ArrayList<Color>();
		
		for(int x = 0; x < map.getWidth(); x++){
			for(int y = 0; y < map.getHeight(); y++){
				if(x % seperator == 0 && y % seperator == 0)
					colors.add(new Color(map.getRGB(x, y)));
			}
		}
	}
	

	public ArrayList<Color> getColors(){return colors;}
}
