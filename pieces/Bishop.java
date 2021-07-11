package pieces;

import misc.Icons;
import misc.PieceType;

public class Bishop extends ChessPiece {

    public Bishop(boolean white) {
        super(PieceType.BISHOP, white, (white ? Icons.WHITEBISHOP : Icons.BLACKBISHOP).getIcon());
    }
    
}
