import java.util.Scanner;

class knapsack {
    static int[] values, weights;
    static int numItem, weight;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            weight = in.nextInt();
            numItem = in.nextInt();

            weights = new int[numItem];
            values = new int[numItem];

            for (int i = 0; i < numItem; i++) {
                values[i] = in.nextInt();
                weights[i] = in.nextInt();
            }

            find();
        }
    }

    static void find() {
        int[][] dp = new int[numItem + 1][weight + 1];

        for (int i = 1; i <= numItem; i++) {
            for (int w = 1; w <= weight; w++) {
                if (w >= weights[i - 1]) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int res = dp[numItem][weight];

        int w = weight, count = 0;
        String result = "";
        for (int i = numItem; i > 0 && res > 0; i--) {

            if (res == dp[i - 1][w])
                continue;
            else {
                count++;
                result += (i - 1) + " ";

                res = res - values[i - 1];
                w = w - weights[i - 1];
            }
        }

        System.out.println(count);
        System.out.println(result.trim());

    }

}
