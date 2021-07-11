package pieces;

import javax.swing.ImageIcon;

import misc.PieceType;

public abstract class ChessPiece {
    
    private final PieceType pieceType;
    private final boolean white;
    private final ImageIcon icon;

    public ChessPiece(PieceType pieceType, boolean white, ImageIcon icon) {
        this.pieceType = pieceType;
        this.white = white;
        this.icon = icon;
    }

    public PieceType getPieceType() {
        return  this.pieceType;
    }

    public boolean isWhite() {
        return this.white;
    }

    public ImageIcon getIcon() {
        return this.icon;
    }
}
