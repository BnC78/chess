package pieces;

import javax.swing.JButton;
import java.awt.Color;

public abstract class ChessPiece extends JButton {
    
    private final Color color;

    public ChessPiece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
    
}
