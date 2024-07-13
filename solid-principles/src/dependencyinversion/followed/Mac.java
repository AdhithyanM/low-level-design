package dependencyinversion.followed;

public class Mac {
    private final Keyboard keyboard;
    private final Mouse mouse;

    public Mac(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
