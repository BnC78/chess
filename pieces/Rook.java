package pieces;

import java.awt.Color;

import misc.Icons;

public class Rook extends ChessPiece {

    private boolean started;

    public Rook(Color color) {
        super(color);
        this.setIcon((color == Color.WHITE ? Icons.WHITEROOK : Icons.BLACKROOK).getIcon());
        started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void started() {
        this.started = true;
    }
}
