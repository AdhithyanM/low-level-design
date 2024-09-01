package snakeandladder;

public class Snake extends Jump{

    public Snake(int from, int to) throws IllegalAccessException {
        super(from, to);
        validate();
    }

    @Override
    public void validate() throws IllegalAccessException {
        if(this.getTo() >= this.getFrom()) {
            throw new IllegalAccessException("to value should be less than from for Snake");
        }
    }
}
