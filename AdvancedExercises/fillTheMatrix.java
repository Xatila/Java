package ADVANCED.Exercises.MultidimensionalArrays;
 
import java.util.Scanner;
 
public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[n][n];
        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix, n, n);
    }
 
    private static void fillMatrixPatternB(int[][] matrix) {
        int startNum = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col]=startNum++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col]=startNum++;
                }
            }
        }
    }
 
    private static void fillMatrixPatternA(int[][] matrix) {
        int startNum = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[col][row] = startNum++;
            }
        }
    }
 
    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}