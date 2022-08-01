package javaAdvanced.multidimensionalArrays.exercise;
 
import java.util.Arrays;
import java.util.Scanner;
 
public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
 
        String[][] matrix = createMatrix(rows, cols);
 
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] command = input.split("\\s+");
            nukeElement(matrix, command);
            matrix = clearEmptyElements(matrix);
 
            input = scanner.nextLine();
        }
        printMatrix(matrix);
    }
 
    private static String[][] clearEmptyElements(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(matrix[row]).filter(e -> !e.equals("")).toArray(String[]::new);
        }
 
        return Arrays.stream(matrix).filter(e -> e.length != 0).toArray(String[][]::new);
 
    }
 
    private static void nukeElement(String[][] matrix, String[] command) {
        int rowOfElement = Integer.parseInt(command[0]);
        int colOfElement = Integer.parseInt(command[1]);
        int radiusOfExplosion = Integer.parseInt(command[2]);
 
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (colOfElement == col && row >= rowOfElement - radiusOfExplosion && row <= rowOfElement + radiusOfExplosion) {
                    matrix[row][col] = "";
                }
                if (rowOfElement == row && col >= colOfElement - radiusOfExplosion && col <= colOfElement + radiusOfExplosion) {
                    matrix[row][col] = "";
                }
            }
        }
    }
 
    private static String[][] createMatrix(int rows, int cols) {
        int element = 1;
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = "" + element++;
 
            }
        }
        return matrix;
    }
 
    public static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
 
}
 