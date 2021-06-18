package pieces;

import javax.swing.JButton;
import java.awt.Color;

import misc.Icons;

public class Knight extends JButton {

    private Color color;

    public Knight(Color color) {
        super();
        this.setIcon((color == Color.WHITE ? Icons.WHITEKNIGHT : Icons.BLACKKNIGHT).getIcon());
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
