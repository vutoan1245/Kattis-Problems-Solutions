import java.util.Arrays;
import java.util.Scanner;

class ninepacks {
    static int INF = 10000000, MAX = 100002;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int[] count1 = new int[MAX];
        int[] count2 = new int[MAX];
        Arrays.fill(count1, INF);
        Arrays.fill(count2, INF);
        count1[0] = 0;
        count2[0] = 0;

        int size = in.nextInt();
        for (int i = 0; i < size; i++) {
            int num = in.nextInt();

            for (int j = MAX - num - 1; j >= 0; j--) {
                if (count1[j] < count1[j + num]) {
                    count1[j + num] = count1[j] + 1;
                }
            }
        }
        size = in.nextInt();
        for (int i = 0; i < size; i++) {
            int num = in.nextInt();

            for (int j = MAX - num - 1; j >= 0; j--) {
                if (count2[j] < count2[j + num]) {
                    count2[j + num] = count2[j] + 1;
                }
            }
        }

        int result = INF;
        for (int i = 1; i < MAX; i++) {
            result = Math.min(result, count1[i] + count2[i]);
        }

        System.out.println(result == INF ? "impossible" : result);
    }
}
