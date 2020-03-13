import java.util.Scanner;

class islands {
    static final int MAX = 13;
    static int[] arr;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        arr = new int[MAX];

        for (int t = 1; t <= numCase; t++) {

            for (int i = 0; i < MAX; i++) {
                arr[i] = in.nextInt();
            }

            int result = 0;
            for (int i = 1; i < MAX; i++) {
                int min = arr[i];

                for (int j = i + 1; j < MAX; j++) {
                    min = Math.min(min, arr[j - 1]);

                    if (arr[i - 1] < min && arr[j] < min) {
                        result++;
                    }
                }
            }

            System.out.println(t + " " + result);
        }

    }
}
