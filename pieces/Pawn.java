package pieces;

import misc.Icons;

public class Pawn extends ChessPiece {
    
    private boolean started;

    public Pawn(boolean white) {
        super(white, (white ? Icons.WHITEPAWN : Icons.BLACKPAWN).getIcon());
        started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void started() {
        this.started = true;
    }

}
