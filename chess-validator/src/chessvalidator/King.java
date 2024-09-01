package chessvalidator;

public class King extends Piece {
    public King(char color, String position, Board board) {
        super(color, position, board);
    }

    @Override
    public boolean validMove(String destination) {
        return adjacent(destination) && !check(destination);
    }

    // --------- HELPER METHODS ----------
    private boolean adjacent(String destination) {
        int[] diffs = diffs(destination);
        return diffs[0] < 2 && diffs[1] < 2;
    }

    private boolean check(String destination) {
        char enemyColor = (color == 'b') ? 'w' : 'b';
        for(Piece enemy : board.getSet(enemyColor)) {
            if(enemy.validMove(destination)) return true;
        }
        return false;
    }
}
