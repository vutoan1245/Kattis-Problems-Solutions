import java.util.Scanner;
import java.util.ArrayList;

class reachableroads {
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean[] visited;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();

        while (numCase-- > 0) {
            int numNode = in.nextInt();
            int numEdge = in.nextInt();

            adjList = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < numNode; i++) {
                adjList.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < numEdge; i++) {
                int from = in.nextInt();
                int to = in.nextInt();

                adjList.get(from).add(to);
                adjList.get(to).add(from);
            }

            visited = new boolean[numNode];

            int result = 0;
            for (int i = 0; i < numNode; i++) {
                if (!visited[i]) {
                    dfs(i);
                    result++;
                }
            }

            System.out.println(result - 1);
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
