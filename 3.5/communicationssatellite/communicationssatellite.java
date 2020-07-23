import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://open.kattis.com/problems/communicationssatellite
class communicationssatellite {
    static int[] parent;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Point pointList[] = new Point[n];
        for (int i = 0; i < n; i++) {
            pointList[i] = new Point(in.nextInt(), in.nextInt(), in.nextInt());
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = distance(pointList[i], pointList[j]);
                edgeList.add(new Edge(i, j, d));
            }
        }

        Collections.sort(edgeList);

        double result = 0;
        for (Edge e : edgeList) {
            int from = e.from;
            int to = e.to;
            double distance = e.distance;
            // System.out.println(from + " " + to + " " + distance);

            int fromParent = findParent(from);
            int toParent = findParent(to);

            if (fromParent != toParent) {
                parent[fromParent] = toParent;
                result += distance;
            }
        }

        System.out.println(result);
    }

    static int findParent(int index) {
        if (parent[index] == index)
            return index;
        return parent[index] = findParent(parent[index]);
    }

    static double distance(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y) - a.r - b.r;
    }
}

class Edge implements Comparable<Edge> {
    int from, to;
    double distance;

    Edge(int a, int b, double c) {
        from = a;
        to = b;
        distance = c;
    }

    public int compareTo(Edge o) {
        return Double.compare(distance, o.distance);
    }
}

class Point {
    int x, y, r;

    Point(int a, int b, int c) {
        x = a;
        y = b;
        r = c;
    }
}
