import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://open.kattis.com/problems/drivingrange
class drivingrange {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Edge[] edgeList = new Edge[m];
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            edgeList[i] = new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        Arrays.sort(edgeList);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 1, minDistance = 0;
        for (Edge e : edgeList) {
            int fromParent = findParent(e.from);
            int toParent = findParent(e.to);

            if (fromParent != toParent) {
                parent[fromParent] = toParent;
                minDistance = e.distance;

                if (++count == n)
                    break;
            }
        }

        if (count != n) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(minDistance);
        }
    }

    static int findParent(int index) {
        if (parent[index] == index)
            return index;
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
