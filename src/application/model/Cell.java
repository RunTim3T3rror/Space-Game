package application.model;

import application.Utilities.Load;
import application.Utilities.Sprite;
import application.controller.LevelState;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cell extends Entity {

    public static enum CellType
    {
        EMPTY,
        PLAYER,
        SIMPLE,
        BOSS,
        INVISIBLE,
    }

    private CellType cellType;
    private boolean isSelected;

    /**
     * Creats a new Entity With a level
     *
     * @param level Asigns the entity to a level
     */
    public Cell(LevelState level) {
        super(level);
        isSelected = false;
    }

    /***
     * Sets the celltype of a cell
     * @param cellType The cell type to set it to
     */
    public void setCellType(CellType cellType) {
        this.cellType = cellType;
        switch (cellType) {
            case PLAYER:
                setImage(Load.getImage("Player"));
                break;
            case SIMPLE:
                setImage(Sprite.mobSprite.getImage(0));
                break;
            case INVISIBLE:
                setImage(Sprite.mobSprite.getImage(1));
                break;
            case BOSS:
                setImage(Load.getImage("Boss"));
                break;
            case  EMPTY:
                nullImage();
                break;
        }
    }

    /***
     * sets if a cell is selected
     * @param isSelected
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    /**
     * Gets a cells cell tyoe
     * @return The cell type
     */
    public CellType getCellType() { return cellType; }

    /**
     * Gets if a cell is selected
     * @return If a cell is selected
     */
    public boolean isSelected() { return isSelected; }

    /***
     * Draws the cell
     * Draws a rectangle and a corresponding image based on celltype
     * @param g The Graphics context to draw with
     */
    @Override
    public void draw(GraphicsContext g) {
        if (isSelected) {
            g.setFill(new Color(0, 1, 0, 0.5));
            g.fillRect(x, y, 50, 50);
        } else {
            g.strokeRect(x, y, 50, 50);
        }

        if (this.getImage() != null)
            g.drawImage(SwingFXUtils.toFXImage(this.getImage(), null), x, y);
    }
}
