package pieces;

import javax.swing.ImageIcon;

public abstract class ChessPiece {
    
    private final boolean white;
    private final ImageIcon icon;

    public ChessPiece(boolean white, ImageIcon icon) {
        this.white = white;
        this.icon = icon;
    }

    public boolean isWhite() {
        return this.white;
    }

    public ImageIcon getIcon() {
        return this.icon;
    }

}
