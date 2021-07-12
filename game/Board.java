package game;

import misc.ChooseAction;
import misc.Colors;
import misc.Player;
import misc.Start;
import pieces.ChessPiece;

import java.awt.Color;

public class Board {

    private Tile[][] tiles;
    private boolean whiteAtBottom;
    private Tile chosenTile;
    private Player currentPlayer;

    public Board(boolean white) {
        this.createBoard(white);
        this.whiteAtBottom = white;
        this.chosenTile = null;
        this.currentPlayer = Player.WHITE;
    }

    private void createBoard(boolean white) {
        this.tiles = (white ? Start.asWhite() : Start.asBlack());
    }

    public Tile getTile(int row, int column) {
        return this.tiles[row][column];
    }

    private void setTile(int row, int column, Tile tile) {
        this.tiles[row][column] = new Tile(tile.getPiece(), row, column);
    }

    public boolean isEmptyTile(int row, int column) {
        return getTile(row, column).isEmpty();
    }

    public boolean isEnemyTile(int row, int column) {
        return !isEmptyTile(row, column) && !isCurrentPlayersPiece(getTile(row, column).getPiece());
    }

    private boolean isWhiteAtBottom() {
        return this.whiteAtBottom;
    }

    public boolean isAttackingUpwards() {
        return (isWhiteAtBottom() && isCurrentPlayerWhite()) || (!isWhiteAtBottom() && !isCurrentPlayerWhite());
    }

    public Tile getChosenTile() {
        return this.chosenTile;
    }

    private void setChosenTile(Tile tile) {
        this.chosenTile = tile;
    }

    public ChooseAction validateChoose(int row, int column, Color cellStatus) {
        System.out.println(hasChosenTile());
        Tile tile = getTile(row, column);
        if (getChosenTile() == tile) {
            unchooseTile();
            return ChooseAction.UNCHOOSE;
        }
        if (tile.getPiece() != null && isCurrentPlayersPiece(tile.getPiece())) {
            boolean hasChosenTile = hasChosenTile();
            chooseTile(tile);
            return hasChosenTile ? ChooseAction.SWAP : ChooseAction.CHOOSE;
        }
        if (isValidMove(cellStatus)) {
            setTile(tile.getRow(), tile.getColumn(), chosenTile);
            this.chosenTile.setEmpty();
            unchooseTile();
            nextPlayer();
            return ChooseAction.MOVE;
        }
        unchooseTile();
        return ChooseAction.INVALID;
    }

    private boolean isValidMove(Color cellStatus) {
        if (hasChosenTile() && (cellStatus == Colors.POSSIBLE_MOVE || cellStatus == Colors.POSSIBLE_ATTACK)) {
            return true;
        }
        return false;
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
