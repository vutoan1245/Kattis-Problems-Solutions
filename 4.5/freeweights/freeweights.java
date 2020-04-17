import java.util.*;

public class freeweights {
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());

        int[] row1 = new int[n];
        int[] row2 = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            row1[i] = in.nextInt();
            set.add(row1[i]);
        }
        for (int i = 0; i < n; i++) {
            row2[i] = in.nextInt();
            set.add(row2[i]);
        }

        List<Integer> unique = new ArrayList<>(set);
        Collections.sort(unique);

        if (validate(0, row1) && validate(0, row2)) {
            System.out.println(0);
            return;
        }

        int low = 0;
        int high = unique.size();
        int result = 0;

        while (low < high) {
            int mid = (high - low) / 2 + low;
            int num = unique.get(mid);

            if (validate(num, row1) && validate(num, row2)) {
                result = num;
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean validate(int value, int[] row) {

        int cur = 0;
        boolean first = false;
        for (int i = 0; i < n; i++) {
            if (row[i] <= value)
                continue;

            if (first) {
                if (cur != row[i]) {
                    return false;
                }
                first = false;
            } else {
                first = true;
                cur = row[i];
            }
        }

        return !first;
    }
}
