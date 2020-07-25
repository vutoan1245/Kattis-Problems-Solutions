import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://open.kattis.com/problems/treehouses
class treehouses {
    static int[] parent;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numNodes = in.nextInt();
        int connectToLand = in.nextInt();
        int numEdges = in.nextInt();

        Node[] nodeList = new Node[numNodes];
        for (int i = 0; i < numNodes; i++) {
            nodeList[i] = new Node(in.nextDouble(), in.nextDouble());
        }

        parent = new int[numNodes];
        for (int i = 0; i < connectToLand; i++) {
            parent[i] = 0;
        }
        for (int i = connectToLand; i < numNodes; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < numEdges; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            int fromParent = findParent(from);
            int toParent = findParent(to);

            parent[fromParent] = toParent;
        }

        // Minimun Spanning Tree
        ArrayList<Edge> edgeList = new ArrayList<Edge>((numNodes * (numNodes - 1) / 2));
        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) {
                edgeList.add(new Edge(i, j, distance(nodeList[i], nodeList[j])));
            }
        }
        Collections.sort(edgeList);

        double result = 0.0;
        for (Edge e : edgeList) {
            int fromParent = findParent(e.from);
            int toParent = findParent(e.to);

            if (fromParent != toParent) {
                parent[fromParent] = toParent;
                result += e.distance;
            }
        }

        System.out.println(result);
    }

    static int findParent(int index) {
        if (parent[index] == index)
            return index;
        return parent[index] = findParent(parent[index]);
    }

    static double distance(Node a, Node b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}

class Edge implements Comparable<Edge> {
    int from, to;
    double distance;

    Edge(int f, int t, double d) {
        from = f;
        to = t;
        distance = d;
    }

    public int compareTo(Edge o) {
        return Double.compare(distance, o.distance);
    }
}

class Node {
    double x, y;

    Node(double a, double b) {
        x = a;
        y = b;
    }
}
