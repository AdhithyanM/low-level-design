package snakeandladder;

public class Ladder extends Jump {
    public Ladder(int from, int to) throws IllegalAccessException {
        super(from, to);
        validate();
    }

    @Override
    public void validate() throws IllegalAccessException {
        if(this.getTo() <= this.getFrom()) {
            throw new IllegalAccessException("to must be greater than from for the Ladder");
        }
    }
}
