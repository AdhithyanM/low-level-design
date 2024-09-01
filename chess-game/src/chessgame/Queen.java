package chessgame;

import java.util.List;

public class Queen extends Piece {
    public Queen(Color color) {
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
