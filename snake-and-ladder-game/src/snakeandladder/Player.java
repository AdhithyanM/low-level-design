package snakeandladder;

import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private int location;

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.location = 1;
    }

    public String getId() {
        return id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
