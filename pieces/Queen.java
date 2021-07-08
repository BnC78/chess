package pieces;

import misc.Icons;

public class Queen extends ChessPiece {

    public Queen(boolean white) {
        super(white, (white ? Icons.WHITEQUEEN : Icons.BLACKQUEEN).getIcon());
    }

}
