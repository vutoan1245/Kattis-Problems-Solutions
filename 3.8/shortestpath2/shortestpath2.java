import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class shortestpath2 {
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

            ArrayList<ArrayList<Edge>> adjList = new ArrayList<>(numNode);
            for (int i = 0; i < numNode; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < numEdge; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int t = in.nextInt();
                int p = in.nextInt();
                int c = in.nextInt();

                adjList.get(u).add(new Edge(v, t, p, c));
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
                int time = n.time;

                if (time > costs[index]) {
                    continue;
                }

                for (Edge next : adjList.get(index)) {
                    int nextIndex = next.index;
                    int startTime = getNextTime(time, next);
                    int nextTime = startTime + next.cost;

                    if (startTime != -1 && nextTime < costs[nextIndex]) {
                        costs[nextIndex] = nextTime;
                        pq.add(new Node(nextIndex, nextTime));
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

    static int getNextTime(int curTime, Edge next) {
        if (next.start >= curTime)
            return next.start;
        if (next.interval == 0)
            return -1;

        int diff = curTime - next.start;
        int multi = (int) Math.ceil(1.0 * diff / next.interval);

        return next.start + multi * next.interval;
    }

    static class Node implements Comparable<Node> {
        int index, time;

        Node(int i, int t) {
            index = i;
            time = t;
        }

        public int compareTo(Node o) {
            return time - o.time;
        }
    }

    static class Edge {
        int index, start, interval, cost;

        Edge(int a, int b, int c, int d) {
            index = a;
            start = b;
            interval = c;
            cost = d;
        }
    }
}
