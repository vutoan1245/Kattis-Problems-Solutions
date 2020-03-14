import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class wheresmyinternet {
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = in.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);

        adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            strArr = in.readLine().split(" ");
            int from = Integer.parseInt(strArr[0]) - 1;
            int to = Integer.parseInt(strArr[1]) - 1;

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        visited = new boolean[n];

        dfs(0);
        boolean connected = true;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result.append(i + 1 + "\n");
                connected = false;
            }
        }

        if (connected) {
            result.append("Connected\n");
        }

        System.out.print(result.toString());
    }

    static void dfs(int i) {
        if (visited[i])
            return;
        visited[i] = true;

        for (int next : adjList.get(i)) {
            if (!visited[next])
                dfs(next);
        }
    }
}
