package pieces;

import java.awt.Color;

import misc.Icons;

public class Pawn extends ChessPiece {
    
    private boolean started;

    public Pawn(Color color) {
        super(color);
        this.setIcon((color == Color.WHITE ? Icons.WHITEPAWN : Icons.BLACKPAWN).getIcon());
        started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void started() {
        this.started = true;
    }
}
