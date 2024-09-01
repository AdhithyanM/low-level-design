package chessgame;

public class Cell {
    private Piece piece;
    private Color color;

    public Cell(Color color) {
        this.color = color;
        this.piece = null;
    }

    public Cell(Color color, Piece piece) {
        this.color = color;
        this.piece = piece;
    }

    public Color getColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
