import java.util.Scanner;

class countingstars {
    static int[] dr = new int[] { 0, 0, 1, -1 };
    static int[] dc = new int[] { 1, -1, 0, 0 };
    static int rows, cols;
    static char[][] matrix;
    static boolean[][] visited;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int caseCount = 1;
        while (in.hasNext()) {
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
                    if (matrix[i][j] == '-' && !visited[i][j]) {
                        result++;
                        fill(i, j);
                    }
                }
            }

            System.out.printf("Case %d: %d\n", caseCount++, result);
        }
    }

    static void fill(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }
        if (visited[r][c] || matrix[r][c] == '#') {
            return;
        }
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            fill(r + dr[i], c + dc[i]);
        }
    }
}
