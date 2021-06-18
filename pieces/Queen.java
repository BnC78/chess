package pieces;

import javax.swing.JButton;
import java.awt.Color;

import misc.Icons;

public class Queen extends JButton {

    private Color color;

    public Queen(Color color) {
        super();
        this.setIcon((color == Color.WHITE ? Icons.WHITEQUEEN : Icons.BLACKQUEEN).getIcon());
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
