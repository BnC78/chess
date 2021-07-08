package pieces;

import misc.Icons;

public class King extends ChessPiece {

    private boolean started;

    public King(boolean white) {
        super(white, (white ? Icons.WHITEKING : Icons.BLACKKING).getIcon());
        started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void started() {
        this.started = true;
    }

}
