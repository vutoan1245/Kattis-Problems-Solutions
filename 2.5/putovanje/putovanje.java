import java.util.Scanner;

class putovanje {
    public static void main(String arsg[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), c = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;
            for (int j = i; j < n; j++) {
                if (sum + arr[j] <= c) {
                    sum += arr[j];
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

}
