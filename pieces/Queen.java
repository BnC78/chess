package pieces;

import java.awt.Color;

import misc.Icons;

public class Queen extends ChessPiece {


    public Queen(Color color) {
        super(color);
        this.setIcon((color == Color.WHITE ? Icons.WHITEQUEEN : Icons.BLACKQUEEN).getIcon());
    }

}
