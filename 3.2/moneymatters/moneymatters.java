import java.util.ArrayList;
import java.util.Scanner;

// https://open.kattis.com/problems/moneymatters
class moneymatters {
    static int n, m;
    static int[] own;
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        own = new int[n];
        for (int i = 0; i < n; i++) {
            own[i] = in.nextInt();
        }

        adjList = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        visited = new boolean[n];
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            if (dfs(i) != 0) {
                possible = false;
            }
        }

        System.out.println(possible ? "POSSIBLE" : "IMPOSSIBLE");

    }

    static int dfs(int index) {
        if (visited[index])
            return 0;
        visited[index] = true;

        int result = own[index];
        for (int next : adjList.get(index)) {
            result += dfs(next);
        }

        return result;
    }
}
