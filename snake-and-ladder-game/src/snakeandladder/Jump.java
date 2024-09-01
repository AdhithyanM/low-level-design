package snakeandladder;

public abstract class Jump {
    private final int from;
    private final int to;

    public Jump(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public abstract void validate() throws IllegalAccessException;
}
