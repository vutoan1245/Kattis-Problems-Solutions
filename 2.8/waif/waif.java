import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class waif {
    public static void main(String arsg[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();

        int size = n + m + p + 2;
        int src = 0, target = size - 1;
        int cap[][] = new int[size][size];

        for (int i = 0; i < n; i++) {
            cap[src][i + 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                int toy = in.nextInt() - 1;
                cap[1 + i][1 + n + toy] = 1;
            }
        }

        boolean visited[] = new boolean[m];
        for (int i = 0; i < p; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                int toy = in.nextInt() - 1;
                cap[1 + n + toy][1 + n + m + i] = 1;
                visited[toy] = true;
            }

            int r = in.nextInt();
            cap[1 + n + m + i][target] = r;
        }

        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                cap[1 + n + i][target] = 1;
            }
        }

        Network nk = new Network(src, target, size, cap);

        System.out.println(nk.maxFlow());
    }

    static class Network {
        int size, src, target;
        int cap[][];
        int parent[];

        Network(int s, int t, int n, int[][] c) {
            src = s;
            target = t;
            size = n;
            cap = c;
        }

        int maxFlow() {
            int result = 0;
            while (bfs()) {
                result += augment(target, Integer.MAX_VALUE);
            }

            return result;
        }

        int augment(int to, int min) {
            if (to == src) {
                return min;
            }
            int from = parent[to];

            int flow = augment(from, Math.min(min, cap[from][to]));

            cap[from][to] -= flow;
            cap[to][from] += flow;

            return flow;
        }

        boolean bfs() {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(src);

            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = -1;
            }
            parent[src] = src;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (cur == target) {
                    return true;
                }

                for (int i = 0; i < size; i++) {
                    if (parent[i] == -1 && cap[cur][i] > 0) {
                        parent[i] = cur;
                        queue.add(i);
                    }
                }
            }

            return false;
        }
    }
}
