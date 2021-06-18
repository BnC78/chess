package pieces;

import javax.swing.JButton;

import misc.Color;
import misc.Icons;

public class Pawn extends JButton {
    
    private Color color;
    private boolean started;

    public Pawn(Color color) {
        this.setIcon((color == Color.WHITE ? Icons.WHITEPAWN : Icons.BLACKPAWN).getIcon());
        started = false;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void started() {
        this.started = true;
    }
}
