import java.util.Scanner;

class amoebas {
    static int rows, cols;
    static char[][] matrix;
    static boolean[][] visited;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        rows = in.nextInt();
        cols = in.nextInt();

        matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = in.next().toCharArray();
        }

        visited = new boolean[rows][cols];

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && matrix[i][j] == '#') {
                    fill(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void fill(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }

        if (matrix[r][c] == '.' || visited[r][c]) {
            return;
        }
        visited[r][c] = true;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                fill(r + i, c + j);
            }
        }

    }
}
