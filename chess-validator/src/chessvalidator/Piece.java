package chessvalidator;

import java.util.HashMap;
import java.util.Map;

public abstract class Piece {
    char color;
    String position;
    Board board;

    private static final Map<String, Character> pieceShortNames = new HashMap<>();
    static {
        pieceShortNames.put("Rook", 'r');
        pieceShortNames.put("Bishop", 'b');
        pieceShortNames.put("Knight", 'n');
        pieceShortNames.put("Queen", 'q');
        pieceShortNames.put("King", 'k');
        pieceShortNames.put("Pawn", 'p');
    }

    public Piece(char color, String position, Board board) {
        this.color = color;
        this.position = position;
        this.board = board;
    }

    public abstract boolean validMove(String destination);

    protected boolean enemy(Piece piece) {
        return piece.color != color;
    }

    protected int[] diffs(String destination) {
        int columnDiff = Math.abs(position.charAt(0) - destination.charAt(0));
        int rowDiff = Math.abs(position.charAt(1) - destination.charAt(1));
        return new int[] {columnDiff, rowDiff};
    }

    @Override
    public String toString() {
        return (color == 'b' ? "Black" : "White") + " " + this.getClass().getSimpleName() + " at " + position;
    }

    public String toSimpleString() {
        return color+""+pieceShortNames.get(this.getClass().getSimpleName());
    }
}
