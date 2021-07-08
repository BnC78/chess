package pieces;

import java.awt.Color;

import misc.Icons;

public class Bishop extends ChessPiece {

    public Bishop(Color color) {
        super(color);
        this.setIcon((color == Color.WHITE ? Icons.WHITEBISHOP : Icons.BLACKBISHOP).getIcon());
    }
    
}
