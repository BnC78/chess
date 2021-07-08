package game;

import javax.swing.JButton;

public class Cell extends JButton {

    private final int row;
    private final int column;

    public Cell(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
    
}
