package chessgame;

import java.util.UUID;

public class Account {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    // other info like which state, country they belong to


    public Account(String firstName, String lastName, String email, String password) {
        this.email = email;
        this.firstName = firstName;
        this.id = UUID.randomUUID();
        this.lastName = lastName;
        this.password = password;
    }
}
