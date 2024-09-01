package matrix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix3 = {
                {0, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 0},
        };

        printDiagonals(matrix2);
        printAntiDiagonals(matrix2);
        System.out.println(checkDiagonal(matrix3, 4));
    }

    private static boolean checkDiagonal(int[][] matrix, int N) {
        int n = matrix.length;
        int m = matrix[0].length;
        // figure out the starting points of each diagonal
        List<int[]> startingPoints = new ArrayList<>();
        for(int col = 0; col < m; col++) {
            startingPoints.add(new int[]{0, col});
        }
        for(int row = 1; row < n; row++) {
            startingPoints.add(new int[]{row, 0});
        }
        // iterate and print each diagonal
        for(int[] diagonal : startingPoints) {
            int count = 0;
            int row = diagonal[0] + 1;
            int col = diagonal[1] + 1;
            while(row < n && col < m) {
                if(matrix[row][col] == 1) {
                    count++;
                    if(count == N) return true;
                } else{
                    count = 0;
                }
                row++;
                col++;
            }
            if(count == N) return true;
        }
        return false;
    }

    private static void printDiagonals(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // figure out the starting points of each diagonal
        List<int[]> startingPoints = new ArrayList<>();
        for(int col = 0; col < m; col++) {
            startingPoints.add(new int[]{0, col});
        }
        for(int row = 1; row < n; row++) {
            startingPoints.add(new int[]{row, 0});
        }
        // iterate and print each diagonal
        System.out.println("Diagonals of the given matrix: ");
        for(int[] diagonal : startingPoints) {
            int row = diagonal[0];
            int col = diagonal[1];
            while(row < n && col < m) {
                System.out.print(matrix[row][col] + " ");
                row++;
                col++;
            }
            System.out.println();
        }
    }

    private static void printAntiDiagonals(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<int[]> startingPoints = new ArrayList<>();
        for(int row = 0; row < n; row++) {
            startingPoints.add(new int[]{row, m-1});
        }
        for(int col = 0; col < m-1; col++) {
            startingPoints.add(new int[]{0, col});
        }
        // iterate and print each anti diagonal
        System.out.println("Anti Diagonals of the given matrix: ");
        for(int[] diagonal : startingPoints) {
            int row = diagonal[0];
            int col = diagonal[1];
            while(row < n && col >= 0) {
                System.out.print(matrix[row][col] + " ");
                row++;
                col--;
            }
            System.out.println();
        }
    }
}
