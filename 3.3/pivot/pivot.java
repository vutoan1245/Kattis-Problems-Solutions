import java.util.Scanner;

// https://open.kattis.com/problems/pivot
class pivot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] min = new int[n];
        int[] max = new int[n];
        int maxHolder = Integer.MIN_VALUE, minHolder = Integer.MAX_VALUE;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            minHolder = Math.min(minHolder, arr[j]);
            maxHolder = Math.max(maxHolder, arr[i]);
            max[i] = maxHolder;
            min[j] = minHolder;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= max[i] && arr[i] <= min[i])
                result++;
        }
        System.out.println(result);
    }
}
