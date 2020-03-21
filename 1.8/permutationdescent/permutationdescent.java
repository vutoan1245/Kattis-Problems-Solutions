import java.util.Arrays;
import java.util.Scanner;

class permutationdescent {
    static final int MOD = 1001113;
    static long[][] dp;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();

        while (numCase-- > 0) {
            int id = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();

            dp = new long[n + 1][k + 1];
            for (int i = 0; i <= n; i++)
                Arrays.fill(dp[i], -1);

            System.out.println(id + " " + permutations(n, k));
        }
    }

    static long permutations(int n, int k) {
        if (k == 0 || k == n - 1)
            return 1;
        if (dp[n][k] != -1)
            return dp[n][k];

        return dp[n][k] = ((k + 1) * permutations(n - 1, k) + (n - k) * permutations(n - 1, k - 1)) % MOD;
    }
}
