import java.util.Scanner;

public class MatrixMultiplication {
    static int[][] matrixA;
    static int[][] matrixB;
    static int[][] result;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input matrix dimensions
        System.out.print("Enter the dimensions of matrix A (rows columns): ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        System.out.print("Enter the dimensions of matrix B (rows columns): ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible with these dimensions.");
            return;
        }
        // Initialize matrices
        matrixA = new int[rowsA][colsA];
        matrixB = new int[rowsB][colsB];
        result = new int[rowsA][colsB];
        // Input values for matrix A
        System.out.println("Enter the elements of matrix A:");
        inputMatrixValues(matrixA, scanner);
        // Input values for matrix B
        System.out.println("Enter the elements of matrix B:");
        inputMatrixValues(matrixB, scanner);
        // Create threads for matrix multiplication
        Thread[] threads = new Thread[rowsA];
        for (int i = 0; i < rowsA; i++) {
            threads[i] = new Thread(new MatrixMultiplier(i, colsA));
            threads[i].start();
        }
        // Wait for all threads to finish
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Display the result matrix
        System.out.println("\nResultant Matrix:");
        printMatrix(result);
        scanner.close();
    }
    // Helper method to input matrix values
    private static void inputMatrixValues(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    // Helper method to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MatrixMultiplier implements Runnable {
    private int row;
    private int cols;
    
    public MatrixMultiplier(int row, int cols) {
        this.row = row;
        this.cols = cols;
    }
    @Override
    public void run() {
        for (int i = 0; i < MatrixMultiplication.result[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += MatrixMultiplication.matrixA[row][j] * MatrixMultiplication.matrixB[j][i];
            }
            MatrixMultiplication.result[row][i] = sum;
        }
    }
}
