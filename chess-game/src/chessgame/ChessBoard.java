package chessgame;

public class ChessBoard {
    Cell[][] board;

    public ChessBoard() {
        this.board = new Cell[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // logic for init board
    }

    public boolean makeMove(Move move) {
        CellPosition fromPosition = move.getFromPosition();
        CellPosition toPosition = move.getToPosition();
        Player player = move.getPlayer();
        Piece piece = move.getPiece();

        Cell fromPositionCell = board[fromPosition.getRow()][fromPosition.getCol()];
        Piece fromPositionPiece = fromPositionCell.getPiece();
        
        // check if given piece is the one present in the fromPosition cell
        if (piece.getClass() != fromPositionPiece.getClass() || piece.getColor() != fromPositionPiece.getColor()) {
            return false;
        }
        // check if player is moving the right color piece
        if (player.getColor() != fromPositionPiece.getColor()) {
            return false;
        }
        // validate if toPosition is possible to move by the piece
        if(!piece.validate(fromPosition, toPosition)) {
            return false;
        }

        Cell toPositionCell = board[toPosition.getRow()][toPosition.getCol()];
        Piece toPositionPiece = toPositionCell.getPiece();

        // check if there is a enemy piece existing in toPosition
        if(toPositionPiece != null) {
            move.setKilled(toPositionPiece);
        }
        // update the from and to cell
        fromPositionCell.setPiece(null);
        toPositionCell.setPiece(fromPositionPiece);
        
        return true;
    }
}
