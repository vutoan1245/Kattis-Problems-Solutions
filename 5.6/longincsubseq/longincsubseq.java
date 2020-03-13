import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class longincsubseq {
    static int INF = 100000000;
    static int n, arr[];
    static int size;
    static ArrayList<Integer> list;

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder result = new StringBuilder("");
        while ((line = in.readLine()) != null) {
            n = Integer.parseInt(line);

            arr = new int[n];

            String strArr[] = in.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
            }

            lis();

            result.append(size + "\n");
            for (int i = size - 1; i >= 0; i--) {
                result.append(list.get(i) + " ");
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }

    public static void lis() {
        int[] parent = new int[n];
        int[] lisIndex = new int[n];

        Arrays.fill(parent, -1);

        int lis = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[lisIndex[0]]) {
                lisIndex[0] = i;
            } else if (arr[i] > arr[lisIndex[lis - 1]]) {
                parent[i] = lisIndex[lis - 1];
                lisIndex[lis++] = i;
            } else {

                int l = -1;
                int r = lis - 1;
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

        size = lis;
        list = new ArrayList<Integer>(n);
        for (int i = lisIndex[lis - 1]; i >= 0; i = parent[i]) {
            list.add(i);
        }

    }

}
