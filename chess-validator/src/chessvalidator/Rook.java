package chessvalidator;

public class Rook extends Piece {
    public Rook(char color, String position, Board board) {
        super(color, position, board);
    }

    @Override
    public boolean validMove(String destination) {
        // if same col, check for obstacles in between source and destination
        if(this.position.charAt(0) == destination.charAt(0)) {
            return !obstaclesInColumn(destination);
        }
        // if same row, check for obstacles in between source and destination
        if(this.position.charAt(1) == destination.charAt(1)) {
            return !obstaclesInRow(destination);
        }
        // different col, row - invalid
        return false;
    }

    // ------------ HELPER METHODS -------------
    private boolean obstaclesInColumn(String destination) {
        char col = this.position.charAt(0);
        // determine start and finish
        int start = this.position.charAt(1) - '0';
        int end = destination.charAt(1) - '0';
        start = Math.min(start, end) + 1;
        end = Math.max(start, end) - 1;
        // check for occupant
        for(int row = start; row <= end; row++) {
            String curr =  "" + col + row;
            if(board.getPiece(curr) != null) return true;
        }
        return false;
    }

    private boolean obstaclesInRow(String destination) {
        char row = this.position.charAt(1);
        // determine start and finish
        int start = this.position.charAt(0) - 'a';
        int end = destination.charAt(0) - 'a';
        start = Math.min(start, end) + 1;
        end = Math.max(start, end) - 1;
        // check for occupant
        for(int col = start; col <= end; col++) {
            String curr =  "" + (char) ('a' + col) + row;
            if(board.getPiece(curr) != null ) return true;
        }
        return false;
    }
}
