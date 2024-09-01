package chessvalidator;

public class Pawn extends Piece {
    // variable to determine which direction it should move
    private final int forward;

    public Pawn(char color, String position, Board board) {
        super(color, position, board);
        this.forward = (color == 'b') ? -1 : 1;
    }

    @Override
    public boolean validMove(String destination) {
        return destination.equals(frontSquare()) || canCapture(destination) || longStart(destination);
    }

    // -------- HELPER METHODS ---------
    private String frontSquare() {
        char col = this.position.charAt(0);
        int row = this.position.charAt(1) + forward;
        return "" + col + (char) row;
    }

    private boolean canCapture(String destination) {
        Piece occupant = board.getPiece(destination);
        return occupant != null && enemy(occupant)
                && destination.charAt(1) == this.position.charAt(1) + forward
                && Math.abs(destination.charAt(0) - this.position.charAt(0)) == 1;
    }

    private boolean longStart(String destination) {
        // check if current position is the starting row
        if((color == 'b' && this.position.charAt(1) != '7')
         || (color == 'w' && this.position.charAt(1) != '2')) {
            return false;
        }

        String longStartSquare = "" + this.position.charAt(0) + (char) (this.position.charAt(1) + 2 * forward);
        return destination.equals(longStartSquare);
    }
}
