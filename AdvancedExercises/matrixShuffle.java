import java.util.Scanner;
 
public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine(); //"3 4" -> split -> ["3", "4"]
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);
 
        String [][] matrix = new String[rows][cols];
        fillMatrix(scanner, matrix, rows);
 
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            //невалидна команда
            if(!validateCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            } else { //валидна команда -> започва с думата swap + 4 елемента
                //"swap 0 0 1 1"
                String [] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);
 
                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];
 
                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;
 
                printMatrix(matrix, rows, cols);
 
            }
 
            command = scanner.nextLine();
        }
 
 
 
    }
 
    private static boolean validateCommand(String command, int rows, int cols) {
        //true -> валидна
        //false -> невалидна
        //command = "swap row1 col1 row2 col2"
        String[] commandParts = command.split("\\s+"); // ["swap", "2", "3", "4", "5"]
 
        //1. започва със swap
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        //2. има определен брой части
        if (commandParts.length != 5) {
            return false;
        }
        //3. проверка дали координатите са вътре в матрицата
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);
 
        if (row1 < 0 || row1 >= rows || row2 < 0
                || row2 >= rows || col1 < 0 || col1 >= cols
                || col2 < 0 || col2 > cols) {
            return false;
        }
 
        return true;
    }
 
    private static void fillMatrix(Scanner scanner, String[][] m, int rows) {
        for (int row = 0; row < rows; row++) {
            m[row] = scanner.nextLine().split("\\s+");
            //"1 2 3".split(" ") -> ["1", "2", "3"]
        }
    }
 
 
    public static void printMatrix (String [][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}