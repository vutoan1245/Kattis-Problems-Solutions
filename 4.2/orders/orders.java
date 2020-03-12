import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class orders {
    static final int MAX = 30000;

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] state = new int[MAX + 1];
        Arrays.fill(state, -1);
        state[0] = 0;

        // -1: Impossible
        // -2: Ambiguous
        for (int i = 0; i < n; i++) {
            int cost = arr[i];
            for (int j = cost; j <= MAX; j++) {
                if (state[j - cost] >= 0) {
                    if (state[j] == -1) {
                        state[j] = i + 1;
                    } else {
                        state[j] = -2;
                    }
                }
                if (state[j - cost] == -2) {
                    state[j] = -2;
                }
            }
        }

        int k = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < k; i++) {
            int cost = Integer.parseInt(st.nextToken());
            switch (state[cost]) {
                case -1:
                    System.out.println("Impossible");
                    break;
                case -2:
                    System.out.println("Ambiguous");
                    break;
                default:
                    StringBuilder result = new StringBuilder("");
                    while (state[cost] != 0) {
                        result.insert(0, " " + state[cost]);
                        cost -= arr[state[cost] - 1];
                    }
                    result.deleteCharAt(0);
                    System.out.println(result.toString());
                    break;
            }
        }
    }
}
