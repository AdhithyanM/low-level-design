package chessgame;

public class Move {
    private Player player;
    private Piece piece;
    private CellPosition fromPosition;
    private CellPosition toPosition;
    private Piece killed;

    public Move(Player player, Piece piece, CellPosition fromPosition, CellPosition toPosition) {
        this.player = player;
        this.piece = piece;
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public Player getPlayer() {
        return player;
    }

    public Piece getPiece() {
        return piece;
    }

    public CellPosition getFromPosition() {
        return fromPosition;
    }

    public CellPosition getToPosition() {
        return toPosition;
    }

    public Piece getKilled() {
        return killed;
    }

    public void setKilled(Piece killed) {
        this.killed = killed;
    }
}
