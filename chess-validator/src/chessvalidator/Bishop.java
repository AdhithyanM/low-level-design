package chessvalidator;

public class Bishop extends Piece {
    public Bishop(char color, String position, Board board) {
        super(color, position, board);
    }

    @Override
    public boolean validMove(String destination) {
        return inDiagonal(destination) && !obstacles(destination);
    }

    // ------- HELPER METHODS --------
    private boolean inDiagonal(String destination) {
        int[] diffs = diffs(destination);
        return diffs[0] == diffs[1];
    }

    private boolean obstacles(String destination) {
        int columnDirection = (this.position.charAt(0) - destination.charAt(0) < 0) ? 1 : -1;
        int rowDirection = (this.position.charAt(1) - destination.charAt(1) < 0) ? 1 : -1;
        return obstacles(this.position, destination, columnDirection, rowDirection);
    }

    private boolean obstacles(String current, String destination, int columnDirection, int rowDirection) {
        if(current.equals(destination)) return false;
        if(!current.equals(this.position) && board.getPiece(current) != null) return true;

        char nextColumn = (char) (current.charAt(0) + columnDirection);
        char nextRow = (char) (current.charAt(1) + rowDirection);
        String next = nextColumn+""+nextRow;
        return obstacles(next, destination, columnDirection, rowDirection);
    }
}
