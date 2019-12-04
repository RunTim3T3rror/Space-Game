package application.controller;

import application.Main;
import application.Utilities.Load;
import application.model.Cell;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreateState implements GameState {

    private Background background;

    private GameStateManager gsm;
    private Point selectedCell = new Point(0, 0);

    private Cell[][] cells = new Cell[Main.WIDTH / 50][Main.HEIGHT / 50];

    /***
     * Constructor for the create state
     * Fills all the cells for width and height
     * @param gsm Sets the game state manager
     */
    public CreateState(GameStateManager gsm){
        this.gsm = gsm;
        background = new Background(Load.getImage("BackgroundMoving"));
        for (int x = 0; x < Main.WIDTH / 50; x++) {
            for (int y = 0; y < Main.HEIGHT / 50; y++) {
                cells[x][y] = new Cell(null);
                cells[x][y].setPosition(x * 50, y * 50);
            }
        }
        cells[selectedCell.x][selectedCell.y].setSelected(true);
        cells[2][10].setCellType(Cell.CellType.PLAYER);
    }

    /***
     * Update function
     * Does nothing
     */
    @Override
    public void update() { }

    /***
     * Function to save the custom level to the customlevel.png
     * Reads all the cells and constructs a map based off it
     */
    private void save() {
        BufferedImage image = new BufferedImage(Main.WIDTH / 50,  Main.HEIGHT / 50, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.createGraphics();
        for (int x = 0; x < Main.WIDTH / 50; x++) {
            for (int y = 0; y < Main.HEIGHT / 50; y++) {
                Cell cell = cells[x][y];
                if (cell.getCellType() == Cell.CellType.SIMPLE) {
                    g.setColor(new java.awt.Color(0, 0, 255));
                    g.fillRect(x, y, 1, 1);
                }
                if (cell.getCellType() == Cell.CellType.INVISIBLE) {
                    g.setColor(new java.awt.Color(0, 255, 0));
                    g.fillRect(x, y, 1, 1);
                }
                if (cell.getCellType() == Cell.CellType.PLAYER) {
                    g.setColor(new java.awt.Color(255, 0, 0));
                    g.fillRect(x, y, 1, 1);
                }
                if (cell.getCellType() == Cell.CellType.BOSS) {
                    g.setColor(new java.awt.Color(255, 0, 255));
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
        g.dispose();
        File file = new File("./Resources/Default/CustomLevel.png");
        try {
            ImageIO.write(image, "png", file);
            gsm.changeState(GameStateManager.MENUSTATE);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Draws the screen
     * Draws all cells onto the screen
     * @param g The graphics context
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        g.setStroke(Color.WHITE);
        background.draw(g);
        for (int x = 0; x < Main.WIDTH / 50; x++) {
            for (int y = 0; y < Main.HEIGHT / 50; y++) {
                cells[x][y].draw(g);
            }
        }
    }

    /***
     * Event when a key is pressed
     * Handles moving cells, placing objects, and saving
     * @param e The keycode of the key pressed
     */
    @Override
    public void keyPressed(int e) {
        if (e == KeyEvent.VK_DOWN) {
            if (selectedCell.y != (Main.HEIGHT / 50) - 1) {
                cells[selectedCell.x][selectedCell.y].setSelected(false);
                selectedCell.setLocation(selectedCell.x, selectedCell.y + 1);
                cells[selectedCell.x][selectedCell.y].setSelected(true);
            }
        }
        if (e == KeyEvent.VK_UP) {
            if (selectedCell.y != 0) {
                cells[selectedCell.x][selectedCell.y].setSelected(false);
                selectedCell.setLocation(selectedCell.x, selectedCell.y - 1);
                cells[selectedCell.x][selectedCell.y].setSelected(true);
            }
        }
        if (e == KeyEvent.VK_RIGHT) {
            if (selectedCell.x != (Main.WIDTH / 50) - 1) {
                cells[selectedCell.x][selectedCell.y].setSelected(false);
                selectedCell.setLocation(selectedCell.x + 1, selectedCell.y);
                cells[selectedCell.x][selectedCell.y].setSelected(true);
            }
        }
        if (e == KeyEvent.VK_LEFT) {
            if (selectedCell.x != 0) {
                cells[selectedCell.x][selectedCell.y].setSelected(false);
                selectedCell.setLocation(selectedCell.x - 1, selectedCell.y);
                cells[selectedCell.x][selectedCell.y].setSelected(true);
            }
        }
        if (e == KeyEvent.VK_1) {
            if (selectedCell.x != 2 || selectedCell.y != 10)
                cells[selectedCell.x][selectedCell.y].setCellType(Cell.CellType.SIMPLE);
        }
        if (e == KeyEvent.VK_2) {
            if (selectedCell.x != 2 || selectedCell.y != 10)
                cells[selectedCell.x][selectedCell.y].setCellType(Cell.CellType.INVISIBLE);
        }
        if (e == KeyEvent.VK_3) {
            if (selectedCell.x != 2 || selectedCell.y != 10)
                cells[selectedCell.x][selectedCell.y].setCellType(Cell.CellType.BOSS);
        }
        if (e == KeyEvent.VK_0) {
            if (selectedCell.x != 2 || selectedCell.y != 10)
                cells[selectedCell.x][selectedCell.y].setCellType(Cell.CellType.EMPTY);
        }
        if (e == KeyEvent.VK_S) {
            save();
        }
        if (e == KeyEvent.VK_BACK_SPACE) {
            gsm.changeState(GameStateManager.MENUSTATE);
        }
    }

    /***
     * Called when the key is released
     * @param e The key code of the released key
     */
    @Override
    public void keyReleased(int e) { }
}
