import java.util.ArrayList;
import java.util.Scanner;

// https://open.kattis.com/problems/mravi
class mravi {
    static ArrayList<ArrayList<Edge>> adjList;
    static int[] requires;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            double factor = in.nextInt() / 100.00;
            int pow = in.nextInt() == 1 ? 2 : 1;

            adjList.get(from).add(new Edge(to, factor, pow));
        }

        requires = new int[n];
        for (int i = 0; i < n; i++) {
            requires[i] = in.nextInt();
        }

        // Binary Search the answer
        double lo = 0;
        double hi = 2 * 1e10;

        while (hi - lo >= 1e-6) {
            double mid = (hi - lo) / 2 + lo;
            if (check(mid, 0)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        System.out.println(hi);
    }

    static boolean check(double v, int index) {
        if (v < requires[index])
            return false;

        boolean result = true;
        for (Edge next : adjList.get(index)) {
            result &= check(Math.pow(v * next.factor, next.pow), next.index);
        }

        return result;
    }

    static class Edge {
        int index;
        double factor;
        int pow;

        Edge(int i, double f, int p) {
            index = i;
            factor = f;
            pow = p;
        }
    }
}
