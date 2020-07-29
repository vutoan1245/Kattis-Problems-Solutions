import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

// https://open.kattis.com/problems/texassummers
public class texassummers {
    static int INF = Integer.MAX_VALUE;;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Point[] shades = new Point[n + 2];
        for (int i = 0; i < n; i++) {
            shades[i] = new Point(in.nextInt(), in.nextInt());
        }
        shades[n] = new Point(in.nextInt(), in.nextInt());
        shades[n + 1] = new Point(in.nextInt(), in.nextInt());
        n += 2;

        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Point a = shades[i];
                Point b = shades[j];
                adjList.get(i).add(new Edge(j, a.dist(b)));
                adjList.get(j).add(new Edge(i, b.dist(a)));
            }
        }

        int[] dist = new int[n + 2];
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
        }
        dist[n] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(n - 2, 0));

        int[] parent = new int[n];

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.dist > dist[cur.index])
                continue;

            for (Edge next : adjList.get(cur.index)) {
                if (cur.dist + next.dist < dist[next.index]) {
                    dist[next.index] = cur.dist + next.dist;
                    parent[next.index] = cur.index;
                    pq.add(new Edge(next.index, dist[next.index]));
                }
            }
        }

        int cur = n - 1;
        Stack<Integer> stack = new Stack<>();
        while (parent[cur] != n - 2) {
            stack.push(parent[cur]);
            cur = parent[cur];
        }

        if (stack.size() == 0) {
            System.out.println("-");
        } else {
            while (!stack.isEmpty())
                System.out.println(stack.pop());
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dist(Point o) {
            return (this.x - o.x) * (this.x - o.x) + (this.y - o.y) * (this.y - o.y);
        }
    }

    static class Edge implements Comparable<Edge> {
        int index, dist;

        Edge(int n, int d) {
            index = n;
            dist = d;
        }

        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    }

}
