import java.util.Scanner;

public class spiderman {
    static final int INF = Integer.MAX_VALUE, MAX = 1000;
    static int n;
    static int[] heights;
    static String[][] move;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();

        while (caseNum-- > 0) {

            n = in.nextInt();

            heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = in.nextInt();
            }

            move = new String[n][MAX + 1];
            dp = new int[n][MAX + 1];

            for (int i = 0; i < n; i++) {
                for (int h = 0; h <= MAX; h++) {
                    move[i][h] = "";
                    dp[i][h] = -1;
                }
            }

            int dist = find(0, 0);

            if (dist == INF) {
                System.out.println("IMPOSSIBLE");
            } else {
                int curHeight = 0;
                String path = "";

                for (int i = 0; i < n; i++) {
                    path += move[i][curHeight];

                    if (move[i][curHeight].equals("U")) {
                        curHeight += heights[i];
                    } else {
                        curHeight -= heights[i];
                    }
                }

                System.out.println(path);

            }
        }

    }

    public static int find(int i, int h) {
        if (h < 0)
            return INF;
        if (i == n - 1 && heights[i] != h)
            return INF;

        if (i == n - 1) {
            move[i][h] = "D";
            dp[i][h] = 0;
            return 0;
        }
        if (dp[i][h] != -1) {
            return dp[i][h];
        }

        int up = find(i + 1, h - heights[i]);
        int down = find(i + 1, h + heights[i]);

        if (up < down) {
            move[i][h] = "D";
            dp[i][h] = Math.max(up, h);
        } else {
            move[i][h] = "U";
            dp[i][h] = Math.max(down, h);
        }

        return dp[i][h];
    }
}
