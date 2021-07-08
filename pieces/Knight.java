package pieces;

import java.awt.Color;

import misc.Icons;

public class Knight extends ChessPiece {

    public Knight(Color color) {
        super(color);
        this.setIcon((color == Color.WHITE ? Icons.WHITEKNIGHT : Icons.BLACKKNIGHT).getIcon());
    }

}
