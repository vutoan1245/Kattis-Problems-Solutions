import java.util.Scanner;

class flippingpatties {
    static final int MAX = 43201;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numOrders = in.nextInt();
        int[] count = new int[MAX];

        for (int i = 0; i < numOrders; i++) {
            int duration = in.nextInt();
            int dueTime = in.nextInt();

            count[dueTime]++;
            count[dueTime - duration]++;
            count[dueTime - duration - duration]++;
        }

        int result = 0;
        for (int i = 0; i < MAX; i++) {
            result = Math.max(result, (count[i] + 1) / 2);
        }

        System.out.println(result);
    }
}
