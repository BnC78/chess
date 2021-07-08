package pieces;

import misc.Icons;

public class Bishop extends ChessPiece {

    public Bishop(boolean white) {
        super(white, (white ? Icons.WHITEBISHOP : Icons.BLACKBISHOP).getIcon());
    }
    
}
