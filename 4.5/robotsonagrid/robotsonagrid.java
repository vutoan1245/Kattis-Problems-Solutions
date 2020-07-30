import java.util.Scanner;

// https://open.kattis.com/problems/robotsonagrid
class robotsonagrid {
    static final int MOD = Integer.MAX_VALUE;
    static int n;
    static boolean[][] matrix, visited;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] line = in.next().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line[j] == '.';
            }
        }

        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = matrix[0][0] ? 1 : 0;
        long result = find(n - 1, n - 1);
        if (result == 0) {
            visited = new boolean[n][n];
            System.out.println(possible(0, 0) ? "THE GAME IS A LIE" : "INCONCEIVABLE");
        } else {
            System.out.println(result);
        }

    }

    static boolean possible(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= n || visited[r][c] || !matrix[r][c])
            return false;
        if (r == n - 1 && c == n - 1 && matrix[r][c])
            return true;
        visited[r][c] = true;

        boolean result = false;
        result |= possible(r + 1, c);
        result |= possible(r - 1, c);
        result |= possible(r, c + 1);
        result |= possible(r, c - 1);

        return result;
    }

    static long find(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return 0;

        if (dp[r][c] != -1)
            return dp[r][c];
        if (!matrix[r][c])
            return dp[r][c] = 0;

        return dp[r][c] = (find(r - 1, c) + find(r, c - 1)) % MOD;
    }
}
