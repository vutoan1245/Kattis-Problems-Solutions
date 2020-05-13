import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://open.kattis.com/problems/shortestpath1
class shortestpath1 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int numNode = in.nextInt();
            int numEdge = in.nextInt();
            int numQuery = in.nextInt();
            int start = in.nextInt();

            if (numNode == 0 && numEdge == 0 && numQuery == 0 && start == 0) {
                break;
            }

            ArrayList<ArrayList<Node>> adjList = new ArrayList<>(numNode);
            for (int i = 0; i < numNode; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < numEdge; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int c = in.nextInt();
                adjList.get(u).add(new Node(v, c));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(start, 0));
            int[] costs = new int[numNode];
            for (int i = 0; i < numNode; i++) {
                costs[i] = INF;
            }
            costs[start] = 0;

            while (!pq.isEmpty()) {
                Node n = pq.poll();
                int index = n.index;
                int cost = n.cost;

                if (cost > costs[index]) {
                    continue;
                }

                for (Node next : adjList.get(index)) {
                    int nextIndex = next.index;
                    int nextCost = cost + next.cost;

                    if (nextCost < costs[nextIndex]) {
                        costs[nextIndex] = nextCost;
                        pq.add(new Node(nextIndex, nextCost));
                    }
                }
            }

            for (int i = 0; i < numQuery; i++) {
                int target = in.nextInt();
                System.out.println(costs[target] == INF ? "Impossible" : costs[target]);
            }
            System.out.println();
        }

    }

    static class Node implements Comparable<Node> {
        int index, cost;

        Node(int i, int c) {
            index = i;
            cost = c;
        }

        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
