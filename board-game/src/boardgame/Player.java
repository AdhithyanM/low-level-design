package boardgame;

import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private Color color;

    public Player(String name, Color color) {
        this.color = color;
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
