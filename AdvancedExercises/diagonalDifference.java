import java.util.Scanner;
 
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][n];
 
        //fill Matrix
        fillMatrix(scanner, matrix);
        //sum Primary
        int sumPrimary = getSumPrimaryDiagonal(matrix);
        //sum Secondary
        int sumSecondary = getSumSecondaryDiagonal(matrix);
        //abs(sumPrimary - sumSecondary)
        System.out.println(Math.abs(sumPrimary - sumSecondary));
 
 
    }
 
    private static int getSumSecondaryDiagonal(int [][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length ; col++) {
                if (col == matrix.length - row - 1) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }
 
    private static int getSumPrimaryDiagonal(int [][] matrix) {
        //обхождаме всички елементи -> сумираме само ако ред == колоната
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length ; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }
 
    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
 
 
    public static void printMatrix (int [][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}