import java.util.Scanner;
import java.util.ArrayList;

class dominoes2 {
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean[] visited;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        while (numCase-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int l = in.nextInt();

            adjList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;

                adjList.get(from).add(to);
            }

            visited = new boolean[n];
            for (int i = 0; i < l; i++) {
                dfs(in.nextInt() - 1);
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    public static void dfs(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;

        for (int next : adjList.get(i)) {
            dfs(next);
        }
    }
}
