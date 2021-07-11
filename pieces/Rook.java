package pieces;

import misc.Icons;
import misc.PieceType;

public class Rook extends ChessPiece {

    private boolean started;

    public Rook(boolean white) {
        super(PieceType.ROOK, white, (white ? Icons.WHITEROOK : Icons.BLACKROOK).getIcon());
        started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void started() {
        this.started = true;
    }
}
