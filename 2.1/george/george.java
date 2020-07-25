import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://open.kattis.com/problems/george
class george {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numNodes = in.nextInt();
        int numEdges = in.nextInt();

        int start = in.nextInt() - 1;
        int end = in.nextInt() - 1;
        int startTime = in.nextInt();
        int numGeorgeCities = in.nextInt();
        int[] georgeCityList = new int[numGeorgeCities];
        for (int i = 0; i < numGeorgeCities; i++) {
            int city = in.nextInt() - 1;
            georgeCityList[i] = city;
        }

        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjList.add(new ArrayList<>());
        }
        int[][] adjMatrix = new int[numNodes][numNodes];

        for (int i = 0; i < numEdges; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            int timeCost = in.nextInt();

            adjList.get(from).add(new Node(to, timeCost));
            adjList.get(to).add(new Node(from, timeCost));
            adjMatrix[from][to] = adjMatrix[to][from] = timeCost;
        }
        int[] georgeTime = new int[numGeorgeCities];
        for (int i = 1; i < numGeorgeCities; i++) {
            georgeTime[i] = georgeTime[i - 1] + adjMatrix[georgeCityList[i - 1]][georgeCityList[i]];
        }

        // Dijkstra's algorithm
        int[] costs = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        costs[start] = startTime;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, startTime));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int timeCost = node.timeCost;
            if (node.index == end) {
                break;
            }
            if (timeCost > costs[node.index]) {
                continue;
            }

            for (Node next : adjList.get(node.index)) {
                int nextCost = timeCost + next.timeCost;

                int curGeorge = Arrays.binarySearch(georgeTime, timeCost);
                if (curGeorge < 0) {
                    curGeorge = -curGeorge - 2;
                }
                if (curGeorge < numGeorgeCities - 1) {
                    int from = Math.min(georgeCityList[curGeorge], georgeCityList[curGeorge + 1]);
                    int to = Math.max(georgeCityList[curGeorge], georgeCityList[curGeorge + 1]);

                    if (Math.min(node.index, next.index) == from && Math.max(node.index, next.index) == to) {
                        nextCost += (georgeTime[curGeorge + 1] - timeCost);
                    }
                }

                if (nextCost < costs[next.index]) {
                    costs[next.index] = nextCost;
                    pq.add(new Node(next.index, nextCost));
                }
            }
        }

        System.out.println(costs[end] - startTime);
    }
}

class Node implements Comparable<Node> {
    int index, timeCost;

    Node(int i, int t) {
        index = i;
        timeCost = t;
    }

    public int compareTo(Node o) {
        return timeCost - o.timeCost;
    }
}
