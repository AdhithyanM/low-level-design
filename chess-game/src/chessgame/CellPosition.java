package chessgame;

public class CellPosition {
    private int row;
    private int col_index;
    private char col;

    public CellPosition(char col, int row) {
        this.col = col;
        this.row = row;
        this.col_index = col - 'A';
    }

    public char getCol() {
        return col;
    }

    public int getColIndex() {
        return col_index;
    }

    public int getRow() {
        return row;
    }
}
