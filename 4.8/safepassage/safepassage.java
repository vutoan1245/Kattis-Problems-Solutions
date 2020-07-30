import java.util.Arrays;
import java.util.Scanner;

class safepassage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = in.nextInt();
        }

        Arrays.sort(times);
        int result = 0;
        if (n == 1) {
            System.out.println(times[0]);
            return;
        }

        while (n > 0) {
            if (n > 3) {
                if (times[n - 1] + times[0] + (times[1] * 2) < (times[0] * 2) + times[n - 1] + times[n - 2]) {
                    result += times[n - 1] + times[0] + (times[1] * 2);
                    n = n - 2;
                } else {
                    result += (times[0] * 2) + times[n - 1] + times[n - 2];
                    n -= 2;
                }
            } else {
                if (n == 2) {
                    result += times[1];
                    n -= 2;
                } else {
                    result += times[n - 1] + times[0] + times[1];
                }
                n -= 3;
            }
        }

        System.out.println(result);
    }
}
