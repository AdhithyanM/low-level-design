package chessgame;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    private ChessBoard chessBoard;
    private List<Move> moves;
    private Player[] players;
    private Player currentPlayer;
    private GameStatus status;

    public ChessGame(Player player1, Player player2, Player currentPlayer) {
        this.chessBoard = new ChessBoard();
        this.moves = new ArrayList<>();
        this.players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        // validate current player
        this.currentPlayer = currentPlayer;
        this.status = GameStatus.ACTIVE;
    }

    public boolean makeMove(Piece piece, CellPosition fromPosition, CellPosition toPosition) {
        Move move = new Move(currentPlayer, piece, fromPosition, toPosition);
        if(chessBoard.makeMove(move)) {
            moves.add(move);
            return true;
        }
        return false;
    }

    public void endGame() {
        status = GameStatus.FORFEIT;
    }

    private void changePlayer() {
        currentPlayer = currentPlayer == players[0] ? players[1] : players[0];
    }
}
