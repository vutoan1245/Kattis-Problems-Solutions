
import java.util.HashMap;
import java.util.Scanner;

public class baloni {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];

            int count = map.getOrDefault(num + 1, 0);
            if (count >= 1) {
                map.put(num + 1, count - 1);
            } else {
                result++;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(result);
    }
}
