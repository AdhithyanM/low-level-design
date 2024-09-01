package boardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<Integer, List<Color>> columns;
    private Map<Integer, Map<Integer, Color>> rows;
    private int width; // columns
    private int height; // rows
    private int N;

    public Board(int width, int height, int N) {
        this.width = width;
        this.height = height;
        this.N = N;
        columns = new HashMap<>();
        rows = new HashMap<>();
    }

    public boolean drop(int columnNumber, Color color) {
        if(columnNumber < 0 || columnNumber >= width) {
            System.out.println("Invalid column number");
            return false;
        }

        columns.putIfAbsent(columnNumber, new ArrayList<>());
        List<Color> columnValues = columns.get(columnNumber);
        int rowNumber = columnValues.size() - 1;

        if(rowNumber + 1 == height) {
            System.out.println("Column is full. Can't insert more");
            return false;
        }

        columnValues.add(color);
        rowNumber = columnValues.size() - 1;
        rows.putIfAbsent(rowNumber, new HashMap<>());
        rows.get(rowNumber).put(columnNumber, color);

//        if(checkColumn(columnValues)) return true;

        return false;
    }

//    private boolean checkColumn() {
//        List<Color> columnValues = columns.get(columnNumber);
//        int
//        int count = 1;
//        System.out.println("colNumber: " + columnNumber + ", rowNumber: " + rowNumber);
//        for(int i = rowNumber - 1; i >= rowNumber - (N-1); i--) {
//            if(columnValues.get(i).equals(columnValues.get(i + 1))) {
//                count++;
//            }
//        }
//        return count == N;
//    }
}
