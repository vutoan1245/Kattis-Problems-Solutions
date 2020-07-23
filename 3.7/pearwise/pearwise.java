import java.util.ArrayList;
import java.util.Scanner;

// https://open.kattis.com/problems/pearwise
class pearwise {
    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] votes = new int[n][n];

        for (int i = 0; i < m; i++) {
            int p = in.nextInt();
            String ballot = in.next();

            for (int j = 0; j < n; j++) {
                int c1 = ballot.charAt(j) - 'A';
                for (int k = j + 1; k < n; k++) {
                    int c2 = ballot.charAt(k) - 'A';
                    votes[c1][c2] += p;
                }
            }
        }

        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (votes[i][j] > votes[j][i]) {
                    adjList.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, visited);

            boolean canWin = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    canWin = false;
                }
            }

            System.out.printf("%c: %s\n", i + 'A', canWin ? "can win" : "can't win");
        }
    }

    static void dfs(int from, boolean[] visited) {
        if (visited[from])
            return;
        visited[from] = true;

        for (int next : adjList.get(from)) {
            dfs(next, visited);
        }
    }
}
