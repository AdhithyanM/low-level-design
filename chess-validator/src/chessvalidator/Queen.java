package chessvalidator;

public class Queen extends Piece {
    private final Rook rook;
    private final Bishop bishop;

    public Queen(char color, String position, Board board) {
        super(color, position, board);
        this.rook = new Rook(color, position, board);
        this.bishop = new Bishop(color, position, board);
    }

    @Override
    public boolean validMove(String destination) {
        return rook.validMove(destination) || bishop.validMove(destination);
    }
}
