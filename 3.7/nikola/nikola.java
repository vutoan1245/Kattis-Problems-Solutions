import java.util.Scanner;

class nikola {
    static final int INF = 10000000;
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(find(0, 0));
    }

    static int find(int i, int len) {
        if (len >= n || i < 0 || i >= n)
            return INF;
        if (i == n - 1)
            return 0;
        if (dp[i][len] != -1)
            return dp[i][len];

        int result = INF;
        if (i + len + 1 < n)
            result = Math.min(result, arr[i + len + 1] + find(i + len + 1, len + 1));
        if (len != 0 && i - len >= 0)
            result = Math.min(result, arr[i - len] + find(i - len, len));

        return dp[i][len] = result;
    }
}
