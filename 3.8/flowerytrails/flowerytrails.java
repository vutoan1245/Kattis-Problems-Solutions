import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// https://open.kattis.com/problems/flowerytrails
class flowerytrails {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numNodes = in.nextInt();
        int numEdges = in.nextInt();

        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        int[][] adjMatrix = new int[numNodes][numNodes];
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < numEdges; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int distance = in.nextInt();
            adjList.get(from).add(new Node(to, distance));
            adjList.get(to).add(new Node(from, distance));

            adjMatrix[from][to] = adjMatrix[to][from] = Math.min(adjMatrix[from][to], distance);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        ArrayList<ArrayList<Integer>> parent = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            parent.add(new ArrayList<>());
        }
        int[] cost = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[0] = 0;
        boolean[] visited = new boolean[numNodes];

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int index = n.index;
            int distance = n.distance;

            if (visited[index]) {
                continue;
            }
            visited[index] = true;

            for (Node next : adjList.get(index)) {
                int nextCost = distance + next.distance;
                if (nextCost < cost[next.index]) {
                    cost[next.index] = nextCost;
                    pq.add(new Node(next.index, nextCost));
                    parent.get(next.index).clear();
                    parent.get(next.index).add(index);
                } else if (nextCost == cost[next.index]) {
                    parent.get(next.index).add(index);
                }
            }
        }

        visited = new boolean[numNodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(numNodes - 1);
        int result = 0;
        while (!queue.isEmpty()) {
            int pos = queue.poll();

            if (visited[pos]) {
                continue;
            }
            visited[pos] = true;

            for (int child : parent.get(pos)) {
                result += adjMatrix[child][pos];
                queue.add(child);
            }
        }

        System.out.println(result * 2);
    }
}

class Node implements Comparable<Node> {
    int index, distance;

    Node(int t, int d) {
        index = t;
        distance = d;
    }

    public int compareTo(Node o) {
        return distance - o.distance;
    }
}
