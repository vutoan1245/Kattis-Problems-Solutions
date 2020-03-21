import java.util.*;

public class wordclouds {
    static int n, maxWidth;
    static int[] arrX, arrY;
    static int[] dp;

    public static void main(String[] args) {
        dp = new int[10000];
        Arrays.fill(dp, -1);

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        maxWidth = in.nextInt();

        arrX = new int[n];
        arrY = new int[n];

        for (int a = 0; a < n; a++) {
            arrX[a] = in.nextInt();
            arrY[a] = in.nextInt();
        }

        System.out.println(solve(0));

        in.close();
    }

    private static int solve(int index) {
        if (dp[index] != -1)
            return dp[index];
        if (index == n)
            return 0;

        int result = Integer.MAX_VALUE;
        int curWidth = 0, curHeight = 0;
        for (int i = index; i < n; i++) {
            curWidth += arrX[i];
            curHeight = Math.max(arrY[i], curHeight);
            if (curWidth > maxWidth) {
                break;
            }

            result = Math.min(result, curHeight + solve(i + 1));
        }

        return dp[index] = result;
    }

}
