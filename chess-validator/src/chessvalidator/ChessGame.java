package chessvalidator;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        String boardString =
                "br bn bb bq bk bb bn br\n" +
                "bp bp bp bp bp bp bp bp\n" +
                "-- -- -- -- -- -- -- --\n" +
                "-- -- -- -- -- -- -- --\n" +
                "-- -- -- -- -- -- -- --\n" +
                "-- -- -- -- -- -- -- --\n" +
                "wp wp wp wp wp wp wp wp\n" +
                "wr wn wb wq wk wb wn wr";

        Board board = new Board(boardString);

        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.nextLine();
            if(input.equals("exit")) {
                break;
            }
            String[] move = input.split(" ");
            if(move.length != 2) {
                System.out.println("Invalid move");
                continue;
            }
            if(board.move(move[0], move[1])) {
                System.out.println(board.toString());
            }
        }
//        System.out.println(board.validMove("e2", "e4")); // True
//        System.out.println(board.validMove("e2", "e5")); // False
//        System.out.println(board.validMove("b1", "c3")); // True
//        System.out.println(board.validMove("b1", "b3")); // False
    }
}
