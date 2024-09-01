package infinitegrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfiniteGrid {
    private Map<Integer, List<Color>> columns;
    private Map<Integer, Map<Integer, Color>> rows;
    private int N;

    public InfiniteGrid(int N) {
        this.N = N;
        columns = new HashMap<>();
        rows = new HashMap<>();
    }

    public boolean drop(int columnNumber, Color color) {
        columns.putIfAbsent(columnNumber, new ArrayList<>());
        List<Color> columnValues = columns.get(columnNumber);
        columnValues.add(color);

        int rowNumber = columnValues.size() - 1;
        rows.putIfAbsent(rowNumber, new HashMap<>());
        rows.get(rowNumber).put(columnNumber, color);

        if(checkCol(columnValues)) {
            System.out.println("Column match");
            return true;
        }

        if(checkRow(rowNumber, columnNumber)) {
            System.out.println("Row match");
            return true;
        }

        if(checkDiagonal(rowNumber, columnNumber)) {
            System.out.println("Diagonal match");
            return true;
        }

        if(checkAntiDiagonal(rowNumber, columnNumber)) {
            System.out.println("Anti diagonal match");
            return true;
        }

        return false;
    }

    private boolean checkCol(List<Color> columnValues) {
        int size = columnValues.size();
        int count = 1;
        if( size >= N) {
            int rowNumber = size - 1; // inserted row number
            for(int i = rowNumber - 1; i >= rowNumber - (N-1); i--) {
                if(columnValues.get(i).equals(columnValues.get(i+1))) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count == N;
    }

    private boolean checkRow(int rowNumber, int columnNumber) {
        Map<Integer, Color> rowValues = rows.get(rowNumber);

        int j = columnNumber + 1;
        int count = 1;

        for(int i = columnNumber - 1; i >= columnNumber - (N-1); i--) {
            if(rowValues.containsKey(i) && rowValues.get(i).equals(rowValues.get(i+1))) {
                count++;
            } else {
                break;
            }
        }

        for(int i = columnNumber + 1; i <= columnNumber + (N-1); i--) {
            if(rowValues.containsKey(i) && rowValues.get(i).equals(rowValues.get(i-1))) {
                count++;
            } else {
                break;
            }
        }

        return count >= N;
    }

    private boolean checkDiagonal(int rowNumber, int columnNumber) {
        // (i1, j1)
        int i1 = rowNumber - 1;
        int j1 = columnNumber + 1;
        // (i2, j2)
        int i2 = rowNumber + 1;
        int j2 = columnNumber - 1;

        int count = 1;
        Color target = rows.get(rowNumber).get(columnNumber);

        while(i1 >= rowNumber - (N-1) && j1 <= columnNumber + (N-1) && i2 <= rowNumber + (N-1) && j2 >= columnNumber + (N-1)) {
            boolean hasAnyMatch = false;
            if(rows.containsKey(i1) && rows.get(i1).containsKey(j1) && rows.get(i1).get(j1).equals(target)) {
                count++;
                i1--;
                j1++;
                hasAnyMatch = true;
            }
            if(rows.containsKey(i2) && rows.get(i2).containsKey(j2) && rows.get(i2).get(j2).equals(target)) {
                count++;
                i2++;
                j2--;
                hasAnyMatch = true;
            }
            if(!hasAnyMatch) {
                break;
            }
        }

        return count >= N;
    }

    private boolean checkAntiDiagonal(int rowNumber, int columnNumber) {
        // (i1, j1)
        int i1 = rowNumber - 1;
        int j1 = columnNumber - 1;
        // (i2, j2)
        int i2 = rowNumber + 1;
        int j2 = columnNumber + 1;

        int count = 1;
        Color target = rows.get(rowNumber).get(columnNumber);

        while(i1 >= rowNumber - (N-1) && j1 >= columnNumber - (N-1) && i2 <= rowNumber + (N-1) && j2 <= columnNumber + (N-1)) {
            boolean hasAnyMatch = false;
            if(rows.containsKey(i1) && rows.get(i1).containsKey(j1) && rows.get(i1).get(j1).equals(target)) {
                count++;
                i1--;
                j1--;
                hasAnyMatch = true;
            }
            if(rows.containsKey(i2) && rows.get(i2).containsKey(j2) && rows.get(i2).get(j2).equals(target)) {
                count++;
                i2++;
                j2++;
                hasAnyMatch = true;
            }
            if(!hasAnyMatch) {
                break;
            }
        }

        return count >= N;
    }
}
