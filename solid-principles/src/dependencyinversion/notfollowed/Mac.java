package dependencyinversion.notfollowed;

/*
    Dependency Inversion Principle
        states that class should depend on interfaces rather than concrete classes

    Here keeping the type as WiredKeyboard, WiredMouse violates Dependency Inversion Principle
    What is tomorrow we need to inject Bluetooth mouse or keyboard?
 */
public class Mac {
    private final WiredKeyboard keyboard;
    private final WiredMouse mouse;

    public Mac(WiredKeyboard keyboard, WiredMouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}
