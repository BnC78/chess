package game;

import javax.swing.JButton;

import java.awt.Color;

public class Cell extends JButton {

    private final int row;
    private final int column;
    private final Tile tile;
    private final Color defaultBg;

    public Cell(int row, int column, Tile tile, Color defaultBg) {
        super();
        this.row = row;
        this.column = column;
        this.tile = tile;
        this.defaultBg = defaultBg;
        this.setBackground(defaultBg);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Tile getTile() {
        return this.tile;
    }

    public void setBackgroundToDefault() {
        this.setBackground(defaultBg);
    }

    public void choose() {
        this.setBackground(Color.CYAN);
    }

    public void unchoose() {
        setBackgroundToDefault();
    }
    
}
