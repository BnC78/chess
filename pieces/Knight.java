package pieces;

import misc.Icons;

public class Knight extends ChessPiece {

    public Knight(boolean white) {
        super(white, (white ? Icons.WHITEKNIGHT : Icons.BLACKKNIGHT).getIcon());
    }

}
