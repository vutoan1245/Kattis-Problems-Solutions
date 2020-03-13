import java.util.Scanner;

class commercials {
    public static void main(String arsg[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int cost = in.nextInt();

        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = in.nextInt() - cost;
        }

        int curMax = 0, result = 0;
        for (int i = 0; i < n; i++) {
            if (curMax < 0) {
                curMax = 0;
            }
            curMax += profit[i];

            result = Math.max(result, curMax);
        }

        System.out.println(result);
    }
}
