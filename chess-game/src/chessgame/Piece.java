package chessgame;

import java.util.List;

public abstract class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract List<CellPosition> possibleMoves(CellPosition fromPosition);
    public abstract boolean validate(CellPosition fromPosition, CellPosition toPosition);
}
