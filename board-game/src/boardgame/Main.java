package boardgame;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(7, 6, 4);

        System.out.println(board.drop(-1, Color.B));
        System.out.println(board.drop(0, Color.B));
        System.out.println(board.drop(0, Color.B));
        System.out.println(board.drop(0, Color.B));
        System.out.println(board.drop(0, Color.B));

        board.drop(1, Color.B);
        board.drop(2, Color.B);

    }
}
