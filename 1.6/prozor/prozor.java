import java.util.Scanner;

class prozor {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();
        int size = in.nextInt() - 2;

        char[][] matrix = new char[rows][cols];
        int[][] matrixSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = in.next().toCharArray();
            for (int j = 0; j < cols; j++) {
                matrixSum[i][j] = matrix[i][j] == '*' ? 1 : 0;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) {
                    matrixSum[i][j] += matrixSum[i - 1][j];
                }
                if (j > 0) {
                    matrixSum[i][j] += matrixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    matrixSum[i][j] -= matrixSum[i - 1][j - 1];
                }
            }
        }

        int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
        int result = 0;
        for (int i = 1; i < rows - size; i++) {
            for (int j = 1; j < cols - size; j++) {
                int r = i + size - 1;
                int c = j + size - 1;
                int max = matrixSum[r][c];

                if (i > 0) {
                    max -= matrixSum[i - 1][c];
                }
                if (j > 0) {
                    max -= matrixSum[r][j - 1];
                }
                if (i > 0 && j > 0) {
                    max += matrixSum[i - 1][j - 1];
                }

                if (max > result) {
                    result = max;
                    r1 = i - 1;
                    r2 = r + 1;
                    c1 = j - 1;
                    c2 = c + 1;
                }

            }
        }

        matrix[r1][c1] = '+';
        matrix[r1][c2] = '+';
        matrix[r2][c1] = '+';
        matrix[r2][c2] = '+';

        for (int i = c1 + 1; i < c2; i++) {
            matrix[r1][i] = '-';
            matrix[r2][i] = '-';
        }
        for (int i = r1 + 1; i < r2; i++) {
            matrix[i][c1] = '|';
            matrix[i][c2] = '|';
        }

        System.out.println(result);
        for (int i = 0; i < rows; i++) {
            System.out.println(new String(matrix[i]));
        }

    }
}
