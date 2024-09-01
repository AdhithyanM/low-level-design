package chessgame;

import java.util.List;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public List<CellPosition> possibleMoves(CellPosition fromPosition) {
        return null;
    }

    @Override
    public boolean validate(CellPosition fromPosition, CellPosition toPosition) {
        return false;
    }
}
