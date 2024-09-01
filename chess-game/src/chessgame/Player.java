package chessgame;

public class Player {
    private Account account;
    private Color color;

    public Player(Account account, Color color) {
        this.account = account;
        this.color = color;
    }

    public Account getAccount() {
        return account;
    }

    public Color getColor() {
        return color;
    }
}
