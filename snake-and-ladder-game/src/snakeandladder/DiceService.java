package snakeandladder;

import java.util.Random;

public class DiceService {
    private static final int MAX_VALUE = 6;
    private static Random random = new Random();

    public static int roll() {
        return 1 + random.nextInt(MAX_VALUE);
    }
}
