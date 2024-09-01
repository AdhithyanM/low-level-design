package snakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameService {
    private final Board board;
    private final List<Player> players;
    private GameStatus status;

    public GameService(Board board) {
        this.board = board;
        this.players = new ArrayList<>();
        this.status = GameStatus.CREATED;
    }

    public void addPlayer(Player player) {
        // todo - validate based on id
        this.players.add(player);
    }

    public void startGame() throws Exception {
        this.status = GameStatus.STARTED;
        if(players.size() <= 1) {
            throw new Exception("There need to be atleast 2 players to start the game");
        }
        int currentPlayerIndex = 0;
        while(hasPlayerLocationIsBeforeLastCell(currentPlayerIndex)) {
            int steps = DiceService.roll();
            if(hasPlayerExceedingLastCell(currentPlayerIndex, steps)) {
                currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
                continue;
            }
            movePlayer(currentPlayerIndex, steps);
            if(hasPlayerWon(currentPlayerIndex)) {
                System.out.println("Player " + currentPlayerIndex + " won!");
                break;
            }
            currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
        }
        this.status = GameStatus.FINISHED;
    }

    public void movePlayer(int playerIndex, int steps) {
        int playerLocation = players.get(playerIndex).getLocation();
        int playerNewLocation = playerLocation + steps;
        Map<Integer, Snake> snakes = board.getSnakes();
        Map<Integer, Ladder> ladders = board.getLadders();

        boolean isLadderPresent = ladders.containsKey(playerNewLocation);
        boolean isSnakePresent = snakes.containsKey(playerNewLocation);

        while(isLadderPresent || isSnakePresent) {
            if(isLadderPresent) {
                playerNewLocation = ladders.get(playerNewLocation).getTo();
            } else {
                playerNewLocation = snakes.get(playerNewLocation).getTo();
            }
            // check for further ladders or snakes in the cell which we currently reached.
            isLadderPresent = ladders.containsKey(playerNewLocation);
            isSnakePresent = snakes.containsKey(playerNewLocation);
        }

        players.get(playerIndex).setLocation(playerNewLocation);
        System.out.println("Player " + players.get(playerIndex).getName() + " moved to " + playerNewLocation + " from " + playerLocation + " by rolling " + steps + " steps");
    }

    public void endGame() {
        this.status = GameStatus.DROPPED;
    }

    public GameStatus getStatus() {
        return status;
    }

    private boolean hasPlayerWon(int playerIndex) {
        return players.get(playerIndex).getLocation() == board.getSize();
    }
    private boolean hasPlayerLocationIsBeforeLastCell(int playerIndex) {
        return players.get(playerIndex).getLocation() < board.getSize();
    }
    private boolean hasPlayerExceedingLastCell(int playerIndex, int steps) {
        return players.get(playerIndex).getLocation() + steps > board.getSize();
    }
    private int getNextPlayerIndex(int currentPlayerIndex) {
        return (currentPlayerIndex + 1) % players.size();
    }
}
