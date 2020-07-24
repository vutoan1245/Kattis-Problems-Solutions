import java.util.Arrays;
import java.util.Scanner;

// https://open.kattis.com/problems/cats
class cats {
    static int[] parent;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCases = in.nextInt();
        while(numCases-- > 0) {
            int milk = in.nextInt();
            int numCats = in.nextInt();

            int size = (numCats * (numCats - 1)) / 2;
            Edge[] edgeList = new Edge[size];
            for (int i = 0; i < size; i++) {
                edgeList[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
            }
            Arrays.sort(edgeList);

            parent = new int[numCats];
            for (int i = 0; i < numCats; i++) {
                parent[i] = i;
            }

            int totalDistance = 0;
            for (Edge e : edgeList) {
                int fromParent = findParent(e.from);
                int toParent = findParent(e.to);

                if (fromParent != toParent) {
                    parent[fromParent] = toParent;
                    totalDistance += e.distance;
                }
            }

            boolean possible = (milk - totalDistance - numCats) >= 0;
            System.out.println(possible ? "yes" : "no");
        }
    }

    static int findParent(int index) {
        if (parent[index] == index) return index;
        return parent[index] = findParent(parent[index]);
    }
}

class Edge implements Comparable<Edge> {
    int from, to, distance;

    Edge(int a, int b, int d) {
        from = a;
        to = b;
        distance = d;
    }

    public int compareTo(Edge o) {
        return distance - o.distance;
    }
}
