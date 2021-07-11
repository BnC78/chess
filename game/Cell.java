package game;

import javax.swing.JButton;

import java.awt.Color;

public class Cell extends JButton {

    private final int row;
    private final int column;
    private final Tile tile;

    private final Color defaultBg;
    private static final Color chosenBg = new Color(4, 146,194);
    private static final Color possibleMoveBg = new Color(250, 226, 156);
    private static final Color possibleAttackBg = new Color(188, 84, 75);

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
        this.setBackground(chosenBg);
    }

    public void unchoose() {
        setBackgroundToDefault();
    }
    
    public void possibleMove() {
        this.setBackground(possibleMoveBg);
    }

    public void possibleAttack() {
        this.setBackground(possibleAttackBg);
    }
}
