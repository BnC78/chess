package pieces;

import javax.swing.JButton;
import java.awt.Color;

import misc.Icons;

public class Pawn extends JButton {
    
    private Color color;
    private boolean started;

    public Pawn(Color color) {
        super();
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
