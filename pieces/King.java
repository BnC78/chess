package pieces;

import java.awt.Color;

import misc.Icons;

public class King extends ChessPiece {

    private boolean started;

    public King(Color color) {
        super(color);
        this.setIcon((color == Color.WHITE ? Icons.WHITEKING : Icons.BLACKKING).getIcon());
        started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void started() {
        this.started = true;
    }
    
}
