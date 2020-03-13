import java.util.Scanner;

class flowshop {
    public static void main(String arsg[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), k = in.nextInt();
        int[][] time = new int[n][k];
        int[][] matrix = new int[n][k];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
                time[i][j] = in.nextInt();
            }
        }

        matrix[0][0] = time[0][0];
        for (int i = 1; i < k; ++i) {
            matrix[0][i] = matrix[0][i - 1] + time[0][i];
        }
        for (int i = 1; i < n; ++i) {
            matrix[i][0] = matrix[i - 1][0] + time[i][0];
            for (int j = 1; j < k; ++j) {
                matrix[i][j] = time[i][j] + Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }

        for (int i = 0; i < n; ++i) {
            System.out.printf("%d ", matrix[i][k - 1]);
        }
        System.out.println();
    }
}
