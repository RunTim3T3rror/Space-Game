package application.model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import application.controller.LevelState;
import application.Utilities.Load;

public class Entity {
	
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
		 * @param level Asigns the entity to a level
		 */
		public Entity(LevelState level){
			this.level = level;
		}
		
		public void setPosition(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public void setImage(BufferedImage image){
			this.image = image;
			//Width and height is based on the image height and width
			Width = image.getWidth(); 
			Height = image.getHeight();
		}
		
		public void setImage(String path){
			setImage(Load.getImage(path));
		}
		public void nullImage() { this.image = null; }
		public void update(){
			getPosition();
		}

		public boolean intersection(Entity e1, Entity e2){
			Rectangle r1 = e1.getRectangle();
			Rectangle r2 = e2.getRectangle();
			
			if(r1.intersects(r2))
				return true;
			else
				return false;
		}
		
		
		public boolean intersection(Entity e){
			Rectangle r1 = getRectangle();
			Rectangle r2 = e.getRectangle();
			
			if(r1.intersects(r2))
				return true;
			else
				return false;
		}
		
		
		
		//Getters
		public int getHeight(){return Height;}
		public int getWidth(){return Width;}
		public Rectangle getRectangle(){return new Rectangle(x, y, Width, Height);}
		public BufferedImage getImage(){return image;}
		public int getX(){return x;}
		public int getY(){return y;}
		public Point getPointPosition(){return new Point(x, y);}
		
		public void draw(GraphicsContext g){
			g.drawImage(SwingFXUtils.toFXImage(this.image, null), x, y);
			//Draw hit box
			//g.drawRect(x, y, Width, Height);
		}

		public void getPosition(){
			//Uses pixel movement
			if(right)
				x += speed;
			if(left)
				x -= speed;
			if(up)
				y -= speed;
			if(down)
				y += speed;
		}
		
		
		/**
		 * 0 = right
		 * 1 = left
		 * 2 = up
		 * down = 3
		 * @return
		 */
		public int getDirection(){
			if(right) return 0;
			if(left) return 1;
			if(up) return 2;
			if(down) return 3;
			
			return -1;
		}
		
		//Getters
		public int getSpeed(){return speed;}
		
		//Setters
		public void setSpeed(int speed){this.speed = speed;}
		public void setRight(boolean right){this.right = right;}
		public void setLeft(boolean left){this.left = left;}
		public void setUp(boolean up){this.up = up;}
		public void setDown(boolean down){this.down = down;}
		
		
}
