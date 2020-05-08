import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

class fire2 {
    static int[] dx = new int[] { 0, 0, 1, -1 };
    static int[] dy = new int[] { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        while (numCase-- > 0) {
            int numCol = in.nextInt();
            int numRow = in.nextInt();

            Queue<Point> queue = new LinkedList<>();
            Queue<Point> next = new LinkedList<>();
            Queue<Point> fire = new LinkedList<>();
            Queue<Point> fireNext = new LinkedList<>();

            boolean[][] canVisit = new boolean[numRow][numCol];
            for (int i = 0; i < numRow; i++) {
                char[] charArr = in.next().toCharArray();
                for (int j = 0; j < numCol; j++) {
                    if (charArr[j] == '@') {
                        queue.add(new Point(i, j));
                        canVisit[i][j] = true;
                    }
                    if (charArr[j] == '.') {
                        canVisit[i][j] = true;
                    }
                    if (charArr[j] == '*') {
                        fire.add(new Point(i, j));
                    }
                }
            }

            int step = 0, result = -1;
            outer: while (!queue.isEmpty()) {

                while (!fire.isEmpty()) {
                    Point p = fire.poll();

                    for (int i = 0; i < 4; i++) {
                        int nextR = p.x + dx[i];
                        int nextC = p.y + dy[i];

                        if (nextR < 0 || nextR >= numRow || nextC < 0 || nextC >= numCol)
                            continue;

                        if (canVisit[nextR][nextC]) {
                            canVisit[nextR][nextC] = false;
                            fireNext.add(new Point(nextR, nextC));
                        }
                    }
                }

                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    canVisit[p.x][p.y] = false;
                    for (int i = 0; i < 4; i++) {
                        int nextR = p.x + dx[i];
                        int nextC = p.y + dy[i];

                        if (nextR < 0 || nextR >= numRow || nextC < 0 || nextC >= numCol) {
                            result = step + 1;
                            break outer;
                        }

                        if (canVisit[nextR][nextC]) {
                            next.add(new Point(nextR, nextC));
                        }
                    }
                }

                step++;
                queue = next;
                next = new LinkedList<>();
                fire = fireNext;
                fireNext = new LinkedList<>();

            }

            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }
}
