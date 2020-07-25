import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://open.kattis.com/problems/wettiles
class wettiles {
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int numXs = in.nextInt();
            if (numXs == -1)
                break;
            int numY = in.nextInt();
            int leakTime = in.nextInt();
            int numLeaks = in.nextInt();
            int numWalls = in.nextInt();

            Queue<Point> queue = new LinkedList<>();
            int[][] matrix = new int[numXs][numY];
            for (int i = 0; i < numLeaks; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                matrix[x][y] = 1;
                queue.add(new Point(x, y));
            }
            for (int i = 0; i < numWalls; i++) {
                int x1 = in.nextInt() - 1;
                int y1 = in.nextInt() - 1;
                int x2 = in.nextInt() - 1;
                int y2 = in.nextInt() - 1;

                while (x1 != x2 || y1 != y2) {
                    matrix[x1][y1] = -1;

                    if (x1 < x2) {
                        x1++;
                    } else if (x1 > x2) {
                        x1--;
                    }
                    if (y1 < y2) {
                        y1++;
                    } else if (y1 > y2) {
                        y1--;
                    }
                }
                matrix[x1][y1] = -1;
            }

            Queue<Point> next = new LinkedList<>();

            for (int t = 2; t <= leakTime && !queue.isEmpty(); t++) {

                while (!queue.isEmpty()) {
                    Point cur = queue.poll();

                    for (int i = 0; i < 4; i++) {
                        int nextX = cur.x + dx[i];
                        int nextY = cur.y + dy[i];

                        if (nextX < 0 || nextX >= numXs || nextY < 0 || nextY >= numY)
                            continue;
                        if (matrix[nextX][nextY] == 0) {
                            next.add(new Point(nextX, nextY));
                            matrix[nextX][nextY] = t;
                        }
                    }
                }

                queue = next;
                next = new LinkedList<>();
            }

            int result = 0;
            for (int j = numY - 1; j >= 0; j--) {
                for (int i = 0; i < numXs; i++) {
                    if (matrix[i][j] > 0)
                        result++;
                }
            }
            System.out.println(result);
        }
    }
}

class Point {
    int x, y;

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
