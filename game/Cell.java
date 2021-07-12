package game;

import javax.swing.JButton;

import misc.Colors;

import java.awt.Color;

public class Cell extends JButton {

    private final int row;
    private final int column;

    private final Color defaultBg;
    private static final Color chosenBg = Colors.CHOSEN;
    private static final Color possibleMoveBg = Colors.POSSIBLE_MOVE;
    private static final Color possibleAttackBg = Colors.POSSIBLE_ATTACK;

    public Cell(int row, int column, Color defaultBg) {
        super();
        this.row = row;
        this.column = column;
        this.defaultBg = defaultBg;
        this.setBackground(defaultBg);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
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
