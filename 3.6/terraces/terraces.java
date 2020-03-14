import java.util.*;

public class terraces {
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int cols, rows;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        cols = in.nextInt();
        rows = in.nextInt();

        boolean[][] visited = new boolean[rows][cols];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;

                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(i, j));

                int count = 0;
                boolean isValid = true;

                while (!queue.isEmpty()) {
                    count++;

                    Node cur = queue.poll();
                    int r = cur.r;
                    int c = cur.c;

                    for (int k = 0; k < 4; k++) {
                        int newR = r + dr[k];
                        int newC = c + dc[k];

                        if (isBound(newR, newC)) {
                            if (!visited[newR][newC] && matrix[newR][newC] == matrix[r][c]) {
                                queue.add(new Node(newR, newC));
                                visited[newR][newC] = true;
                            }

                            if (matrix[newR][newC] < matrix[r][c])
                                isValid = false;
                        }
                    }
                }

                if (isValid)
                    result += count;
            }

        System.out.println(result);
    }

    public static boolean isBound(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}

class Node {
    int r, c;

    public Node(int a, int b) {
        r = a;
        c = b;
    }

}
