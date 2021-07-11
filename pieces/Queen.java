package pieces;

import misc.Icons;
import misc.PieceType;

public class Queen extends ChessPiece {

    public Queen(boolean white) {
        super(PieceType.QUEEN, white, (white ? Icons.WHITEQUEEN : Icons.BLACKQUEEN).getIcon());
    }

}
