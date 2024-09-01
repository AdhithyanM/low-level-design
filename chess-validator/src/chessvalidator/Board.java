package chessvalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    public static final String EMPTY_SQUARE = "--";
    private final Piece[][] board;

    private static final Map<Character, Class<? extends Piece>> PIECE_CLASSES = new HashMap<>();
    static {
        PIECE_CLASSES.put('q', Queen.class);
        PIECE_CLASSES.put('r', Rook.class);
        PIECE_CLASSES.put('b', Bishop.class);
        PIECE_CLASSES.put('k', King.class);
        PIECE_CLASSES.put('p', Pawn.class);
        PIECE_CLASSES.put('n', Knight.class);
    }

    public Board(String rawBoard) {
        this.board = new Piece[8][8];
        parseInput(rawBoard);
    }

    private void parseInput(String rawBoard) {
        String[] tokens = rawBoard.split("\\s+");

        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                String token = tokens[8 * row + col];
                board[row][col] = buildPiece(token, row, col);
            }
        }
        System.out.println(toString());
        System.out.println("Board initialized.");
    }

    private Piece buildPiece(String rawPiece, int row, int col) {
        if(rawPiece.equals(EMPTY_SQUARE)) {
            return null;
        }
        char color = rawPiece.charAt(0);
        String position = coordinatesToAlgebraic(row, col);
        Class<? extends Piece> pieceClass = PIECE_CLASSES.get(rawPiece.charAt(1));
        try {
            return pieceClass.getConstructor(char.class, String.class, Board.class)
                    .newInstance(color, position, this);
        } catch (Exception e) {
            throw new RuntimeException("Error creating piece: "+rawPiece, e);
        }
    }

    // -------- HELPER METHODS --------

    // get piece at particular position
    public Piece getPiece(String position) {
        int[] coordinates = algebraicToCoordinates(position);
        return board[coordinates[0]][coordinates[1]];
    }

    // get pieces of a specific color
    public List<Piece> getSet(char color) {
        List<Piece> pieces = new ArrayList<>();
        for(Piece[] row:  board) {
            for(Piece piece: row) {
                if(piece != null && piece.color == color) {
                    pieces.add(piece);
                }
            }
        }
        return pieces;
    }

    public boolean move(String origin, String destination) {
        if(validMove(origin, destination)) {
            int[] origin_coordinates = algebraicToCoordinates(origin);
            int[] destination_coordinates = algebraicToCoordinates(destination);
            if(board[destination_coordinates[0]][destination_coordinates[1]] != null) {
                board[destination_coordinates[0]][destination_coordinates[1]] = null;
            }
            board[destination_coordinates[0]][destination_coordinates[1]] = board[origin_coordinates[0]][destination_coordinates[1]];
            board[origin_coordinates[0]][destination_coordinates[1]] = null;
            return true;
        }
        return false;
    }

    // determine if a move is valid
    public boolean validMove(String origin, String destination) {
        Piece piece = getPiece(origin);
        return piece != null
                && validAlgebraic(destination)
                && piece.validMove(destination);
    }

    private boolean validAlgebraic(String move) {
        return move.length() == 2
                && move.charAt(0) >= 'a' && move.charAt(0) <= 'h'
                && move.charAt(1) >= '1' && move.charAt(1) <= '8';
    }

    private int[] algebraicToCoordinates(String position) {
        return new int[] {
                '8' - position.charAt(1),  // respective row in board
                position.charAt(0) - 'a'   // respective col in board
        };
    }

    private String coordinatesToAlgebraic(int row, int col) {
        return "" + (char)(col + 'a') + (char)('8' - row);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                if(board[row][col] != null) {
                    sb.append(board[row][col].toSimpleString());
                } else {
                    sb.append(EMPTY_SQUARE);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
