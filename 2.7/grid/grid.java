import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

class grid {
    static int[] dy = new int[] { 0, 0, 1, -1 };
    static int[] dx = new int[] { 1, -1, 0, 0 };

    public static void main(String arsg[]) {
        Scanner in = new Scanner(System.in);

        int numRow = in.nextInt();
        int numCol = in.nextInt();
        int[][] grid = new int[numRow][numCol];
        for (int i = 0; i < numRow; i++) {
            String line = in.next();
            for (int j = 0; j < numCol; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[numRow][numCol];
        visited[0][0] = true;
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> next = new LinkedList<>();
        queue.add(new Point(0, 0));

        int step = 0, result = -1;
        outer: while (!queue.isEmpty()) {

            while (!queue.isEmpty()) {
                Point p = queue.poll();
                if (p.x == numRow - 1 && p.y == numCol - 1) {
                    result = step;
                    break outer;
                }

                int val = grid[p.x][p.y];
                for (int i = 0; i < 4; i++) {
                    int nextX = p.x + val * dx[i];
                    int nextY = p.y + val * dy[i];

                    if (nextX < 0 || nextX >= numRow || nextY < 0 || nextY >= numCol) {
                        continue;
                    }

                    if (!visited[nextX][nextY]) {
                        next.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }

            step++;
            queue = next;
            next = new LinkedList<>();
        }

        System.out.println(result);
    }
}
