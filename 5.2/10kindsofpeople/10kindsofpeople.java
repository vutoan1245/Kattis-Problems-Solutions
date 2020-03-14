import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class kindsofpeople {
    static int[] dR = { 1, -1, 0, 0 };
    static int[] dC = { 0, 0, 1, -1 };
    static int rows, cols;
    static char[][] matrix;
    static int[][] group;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        rows = in.nextInt();
        cols = in.nextInt();

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++)
            matrix[i] = in.next().toCharArray();

        group = new int[rows][cols];
        int groupNum = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (group[i][j] == 0) {
                    bfs(new Node(i, j), groupNum);
                    groupNum++;
                }
            }
        }

        int numQuery = in.nextInt();
        for (int i = 0; i < numQuery; i++) {
            int r1 = in.nextInt() - 1;
            int c1 = in.nextInt() - 1;
            int r2 = in.nextInt() - 1;
            int c2 = in.nextInt() - 1;

            if (group[r1][c1] == group[r2][c2]) {
                System.out.println(matrix[r1][c1] == '0' ? "binary" : "decimal");
            } else {
                System.out.println("neither");
            }
        }

        in.close();
    }

    public static void bfs(Node node, int groupNum) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        group[node.r][node.c] = groupNum;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int r = curr.r;
            int c = curr.c;

            for (int i = 0; i < 4; i++) {
                int newR = r + dR[i];
                int newC = c + dC[i];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols)
                    if (matrix[newR][newC] == matrix[r][c] && group[newR][newC] != groupNum) {
                        group[newR][newC] = groupNum;
                        queue.add(new Node(newR, newC));
                    }
            }
        }

    }

    static class Node {
        int r, c;

        public Node(int a, int b) {
            r = a;
            c = b;
        }

    }
}
