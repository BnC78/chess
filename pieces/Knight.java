package pieces;

import misc.Icons;
import misc.PieceType;

public class Knight extends ChessPiece {

    public Knight(boolean white) {
        super(PieceType.KNIGHT, white, (white ? Icons.WHITEKNIGHT : Icons.BLACKKNIGHT).getIcon());
    }

}
