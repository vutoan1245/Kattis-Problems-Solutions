import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://open.kattis.com/problems/hopscotch50
class hopscotch50 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[][] matrix = new int[n][n];

        ArrayList<ArrayList<Node>> adjList = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
                adjList.get(matrix[i][j] - 1).add(new Node(i, j, 0));
            }
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = INF;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Node p : adjList.get(0)) {
            pq.add(new Node(p.i, p.j, 0));
            cost[p.i][p.j] = 0;
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int val = matrix[node.i][node.j];

            if (val == k) {
                continue;
            }

            for (Node next : adjList.get(val)) {
                int nextDistance = node.distance + distance(node, next);

                if (nextDistance < cost[next.i][next.j]) {
                    cost[next.i][next.j] = nextDistance;
                    pq.add(new Node(next.i, next.j, nextDistance));
                }
            }
        }

        int result = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == k) {
                    result = Math.min(result, cost[i][j]);
                }
            }
        }

        System.out.println(result == INF ? -1 : result);

    }

    static int distance(Node first, Node second) {
        return Math.abs(first.i - second.i) + Math.abs(first.j - second.j);
    }
}

class Node implements Comparable<Node> {
    int i, j, distance;

    Node(int a, int b, int d) {
        i = a;
        j = b;
        distance = d;
    }

    public int compareTo(Node o) {
        return distance - o.distance;
    }
}
