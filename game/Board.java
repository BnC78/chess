package game;

import misc.ChooseAction;
import misc.Player;
import misc.Start;
import pieces.ChessPiece;

public class Board {

    private Tile[][] tiles;
    private Tile chosenTile;
    private Player currentPlayer;

    public Board(boolean white) {
        this.createBoard(white);
        this.chosenTile = null;
        this.currentPlayer = white ? Player.WHITE : Player.BLACK;
    }

    private void createBoard(boolean white) {
        this.tiles = (white ? Start.asWhite() : Start.asBlack());
    }

    public Tile getTile(int row, int column) {
        return this.tiles[row][column];
    }

    public boolean isEmptyTile(int row, int column) {
        return getTile(row, column).isEmpty();
    }

    private Tile getChosenTile() {
        return this.chosenTile;
    }

    private void setChosenTile(Tile tile) {
        this.chosenTile = tile;
    }

    public ChooseAction validateChoose(Tile tile) {
        if (getChosenTile() == tile) {
            unchooseTile();
            return ChooseAction.UNCHOOSE;
        }
        if (tile.getPiece() != null && isCurrentPlayersPiece(tile.getPiece())) {
            boolean hasChosenTile = hasChosenTile();
            chooseTile(tile);
            return hasChosenTile ? ChooseAction.SWAP : ChooseAction.CHOOSE;
        }
        if (isValidMove(tile)) {
            return ChooseAction.MOVE;
        }
        unchooseTile();
        return ChooseAction.INVALID;
    }

    private boolean isValidMove(Tile tile) {
        if (!hasChosenTile()) {
            return false;
        }
        return true;
    }

    private boolean hasChosenTile() {
        return this.chosenTile != null;
    }

    public void chooseTile(Tile tile) {
        setChosenTile(tile);
    }

    public void unchooseTile() {
        setChosenTile(null);
    }

    private Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    private void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    private boolean isCurrentPlayersPiece(ChessPiece piece) {
        return (piece.isWhite() && isCurrentPlayerWhite()) || (!piece.isWhite() && !isCurrentPlayerWhite());
    }

    private boolean isCurrentPlayerWhite() {
        return getCurrentPlayer() == Player.WHITE;
    }

    public void nextPlayer() {
        Player nextPlayer = (isCurrentPlayerWhite()) ? Player.BLACK : Player.WHITE;
        setCurrentPlayer(nextPlayer);
    }


}
