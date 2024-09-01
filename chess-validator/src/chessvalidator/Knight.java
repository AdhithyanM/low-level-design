package chessvalidator;

public class Knight extends Piece {

    public Knight(char color, String position, Board board) {
        super(color, position, board);
    }

    @Override
    public boolean validMove(String destination) {
        int[] diffs = diffs(destination);
        return (diffs[0] == 2 && diffs[1] == 1) || (diffs[0] == 1 && diffs[1] == 2);
    }
}
