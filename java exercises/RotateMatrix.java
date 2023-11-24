public class RotateMatrix {

    static void rotateMatrix(int[][] mat) {
        int n = mat.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int temp = mat[first][i];

                mat[first][i] = mat[last - offset][first];

                mat[last - offset][first] = mat[last][last - offset];

                mat[last][last - offset] = mat[i][last];

                mat[i][last] = temp;
            }
        }
    }

    static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Input matrix:");
        printMatrix(mat);

        rotateMatrix(mat);

        System.out.println("\nOutput matrix:");
        printMatrix(mat);
    }
}

