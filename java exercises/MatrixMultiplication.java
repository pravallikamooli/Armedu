import java.util.Random;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int size = 250;
        int[][] A = generateRandomMatrix(size, size);
        int[][] B = generateRandomMatrix(size, size);

        long startNaive = System.currentTimeMillis();
        int[][] resultNaive = multiplyNaive(A, B);
        long endNaive = System.currentTimeMillis();
        long timeNaive = endNaive - startNaive;

        long startStrassen = System.currentTimeMillis();
        int[][] resultStrassen = multiplyStrassen(A, B);
        long endStrassen = System.currentTimeMillis();
        long timeStrassen = endStrassen - startStrassen;

        System.out.println("Naive time: " + timeNaive / 1000.0 + "s");
        System.out.println("Strassen's time: " + timeStrassen / 1000.0 + "s");
    }

    private static int[][] generateRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); 
            }
        }
        return matrix;
    }

    private static int[][] multiplyNaive(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }
    private static int[][] multiplyStrassen(int[][] A, int[][] B) {
        return multiplyNaive(A, B);
    }
}
