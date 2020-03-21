import java.util.Scanner;

class walrusweights {
    static final int INF = 10000000;
    static int n;
    static int[] weights;
    static int[][] dp, sign;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }

        sign = new int[n][2001];
        dp = new int[n][2001];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 2000; j++) {
                dp[i][j] = -1;
            }
        }

        find(0, 0);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (sign[i][result] == 1) {
                result += weights[i];
            }
        }
        System.out.println(result);
    }

    public static int find(int len, int weight) {
        if (weight >= 2000)
            return INF;
        if (len == n)
            return Math.abs(weight - 1000);
        if (dp[len][weight] != -1)
            return dp[len][weight];

        int ans1 = find(len + 1, weight + weights[len]);
        int ans2 = find(len + 1, weight);

        // Addition generate smaller difference
        if (ans1 <= ans2) {
            sign[len][weight] = 1;
            return dp[len][weight] = ans1;
        } else {
            return dp[len][weight] = ans2;
        }
    }
}
