import java.util.Scanner;

class ticketpricing {
    static int numWeek, minWeek1;
    static int[][] prices, numSold;
    static int[][] dp;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numSeat = in.nextInt();
        numWeek = in.nextInt() + 1;

        prices = new int[numWeek][];
        numSold = new int[numWeek][];
        for (int i = 0; i < numWeek; i++) {
            int k = in.nextInt();

            prices[i] = new int[k];
            numSold[i] = new int[k];
            for (int j = 0; j < k; j++)
                prices[i][j] = in.nextInt();
            for (int j = 0; j < k; j++)
                numSold[i][j] = in.nextInt();
        }

        dp = new int[numWeek][numSeat + 1];
        for (int i = 0; i < numWeek; i++) {
            for (int j = 0; j <= numSeat; j++) {
                dp[i][j] = -1;
            }
        }

        minWeek1 = 0;
        System.out.println(find(0, numSeat));
        System.out.println(minWeek1);
    }

    static int find(int weekIndex, int numSeat) {
        if (weekIndex == numWeek || numSeat == 0)
            return 0;
        if (dp[weekIndex][numSeat] != -1)
            return dp[weekIndex][numSeat];

        int k = prices[weekIndex].length;
        int result = 0;
        for (int i = 0; i < k; i++) {
            int price = prices[weekIndex][i];
            int sold = Math.min(numSeat, numSold[weekIndex][i]);

            int ans = price * sold + find(weekIndex + 1, numSeat - sold);

            if (weekIndex == 0) {
                if (ans > result || (ans == result && price < minWeek1)) {
                    result = ans;
                    minWeek1 = price;
                }
            } else {
                result = Math.max(result, ans);
            }
        }

        return dp[weekIndex][numSeat] = result;
    }
}
