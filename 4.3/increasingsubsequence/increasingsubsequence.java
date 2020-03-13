import java.util.Arrays;
import java.util.Scanner;

class increasingsubsequence {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n;
        while ((n = in.nextInt()) != 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            lis(arr, n);
        }
    }

    public static void lis(int[] arr, int n) {
        int[] parent = new int[n];
        int[] lisIndex = new int[n];

        Arrays.fill(parent, -1);

        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[lisIndex[0]]) {
                lisIndex[0] = i;
            } else if (arr[i] > arr[lisIndex[len - 1]]) {
                parent[i] = lisIndex[len - 1];
                lisIndex[len++] = i;
            } else {

                int l = -1;
                int r = len - 1;
                while (r - l > 1) {
                    int m = l + (r - l) / 2;
                    if (arr[lisIndex[m]] >= arr[i])
                        r = m;
                    else
                        l = m;
                }
                parent[i] = lisIndex[r - 1];
                lisIndex[r] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = lisIndex[len - 1]; i >= 0; i = parent[i]) {
            result.insert(0, " " + arr[i]);
        }
        result.insert(0, len);
        System.out.println(result.toString());

    }
}
