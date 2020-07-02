import java.util.HashMap;
import java.util.Scanner;

// https://open.kattis.com/problems/baloni
class baloni {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : arr) {
            if (map.getOrDefault(num + 1, 0) > 0) {
                map.put(num + 1, map.get(num + 1) - 1);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                result++;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        System.out.println(result);
    }
}
