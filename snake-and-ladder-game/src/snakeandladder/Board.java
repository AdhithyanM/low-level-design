package snakeandladder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int width;
    private final int height;
    private Map<Integer, Snake> snakes;
    private Map<Integer, Ladder> ladders;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public void addSnake(Snake snake) {
        // todo - validations
        this.snakes.put(snake.getFrom(), snake);
    }

    public void addLadder(Ladder ladder) {
        // todo - validations
        this.ladders.put(ladder.getFrom(), ladder);
    }

    public int getSize() {
        return width * height;
    }

    public Map<Integer, Snake> getSnakes() {
        return Collections.unmodifiableMap(snakes);
    }

    public Map<Integer, Ladder> getLadders() {
        return Collections.unmodifiableMap(ladders);
    }
}

