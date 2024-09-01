package snakeandladder;

public class Main {
    public static void main(String[] args) throws Exception {
        Board board = new Board(10, 10);
        board.addSnake(new Snake(10, 5));
        board.addLadder(new Ladder(12, 64));
        board.addLadder(new Ladder(68, 99));

        GameService gameService = new GameService(board);
        gameService.addPlayer(new Player("Anupam"));
        gameService.addPlayer(new Player("Adhithyan"));

        gameService.startGame();
    }
}
