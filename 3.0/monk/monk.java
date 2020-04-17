import java.util.Scanner;

class monk {
    static int n1, n2, totalHeight, totalTime;
    static int[] heights1, heights2, times1, times2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n1 = in.nextInt();
        n2 = in.nextInt();

        heights1 = new int[n1];
        times1 = new int[n1];
        heights2 = new int[n2];
        times2 = new int[n2];

        totalHeight = 0;
        totalTime = 0;
        for (int i = 0; i < n1; i++) {
            heights1[i] = in.nextInt();
            times1[i] = in.nextInt();
            totalHeight += heights1[i];
            totalTime += times1[i];
        }
        for (int i = 0; i < n2; i++) {
            heights2[i] = in.nextInt();
            times2[i] = in.nextInt();
        }

        double low = 0.0, high = totalTime, mid = 0.0;
        while (high - low >= 1e-6) {
            mid = (high + low) / 2;
            if (tooLong(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(mid);
    }

    static boolean tooLong(double t) {
        double len1 = 0.0, len2 = 0.0;

        double timeLeft = t;
        for (int i = 0; i < n1; i++) {
            if (times1[i] >= timeLeft) {
                len1 += (1.0 * heights1[i] / times1[i] * timeLeft);
                break;
            }

            len1 += heights1[i];
            timeLeft -= times1[i];
        }
        timeLeft = t;
        for (int i = 0; i < n2; i++) {
            if (times2[i] >= timeLeft) {
                len2 += (1.0 * heights2[i] / times2[i] * timeLeft);
                break;
            }

            len2 += heights2[i];
            timeLeft -= times2[i];
        }

        return len1 + len2 >= totalHeight;
    }

}
