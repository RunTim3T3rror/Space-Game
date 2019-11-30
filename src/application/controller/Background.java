package application.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;

import java.awt.image.BufferedImage;

public class Background {

	//Background image
	private BufferedImage bg;
	
	//Position
	private int x, y;
	
	//Movement 
	private int dx, dy;
	
	public Background(BufferedImage bg){
		this.bg = bg;
	}
	
	public void setPosition(int x, int y){
		this.x  = x;
		this.y = y;
	}
	
	public void update(){
		x += dx;
		y += dy;
	}
	
	public void draw(GraphicsContext g){
		g.drawImage( SwingFXUtils.toFXImage(bg, null), x, y);
	}
	
	//Setters
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setDx(int dx){this.dx = dx;}
	public void setDy(int dy){this.dy = dy;}
	
	//Getters
	public int getX(){return x;}
	public int getY(){return y;}
	public int getDx(){return dx;}
	public int getDy(){return dy;}
}
