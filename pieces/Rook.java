package pieces;

import javax.swing.JButton;
import java.awt.Color;

import misc.Icons;

public class Rook extends JButton {

    private Color color;
    private boolean started;

    public Rook(Color color) {
        super();
        this.setIcon((color == Color.WHITE ? Icons.WHITEROOK : Icons.BLACKROOK).getIcon());
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
