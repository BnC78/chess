package pieces;

import javax.swing.JButton;

import misc.Color;
import misc.Icons;

public class Bishop extends JButton {

    private Color color;

    public Bishop(Color color) {
        this.setIcon((color == Color.WHITE ? Icons.WHITEBISHOP : Icons.BLACKBISHOP).getIcon());
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
