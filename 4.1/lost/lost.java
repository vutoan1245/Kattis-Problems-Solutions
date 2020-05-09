import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://open.kattis.com/problems/lost
public class lost {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numLang = in.nextInt();
        int numEdge = in.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < numLang; i++) {
            map.put(in.next(), i);
        }
        map.put("English", numLang);

        int[][] adjMatrix = new int[numLang + 1][numLang + 1];
        for (int i = 0; i < numEdge; i++) {
            int l1 = map.get(in.next());
            int l2 = map.get(in.next());
            int c = in.nextInt();
            adjMatrix[l1][l2] = c;
            adjMatrix[l2][l1] = c;
        }

        int[] costs = new int[numLang + 1];
        int[] transDist = new int[numLang + 1];
        for (int i = 0; i < numLang; i++) {
            costs[i] = Integer.MAX_VALUE;
            transDist[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        transDist[numLang] = 0;
        queue.add(numLang);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to = 0; to <= numLang; to++) {
                if (adjMatrix[from][to] == 0 || transDist[to] <= transDist[from]) {
                    continue;
                }

                if (costs[to] > adjMatrix[from][to]) {
                    costs[to] = adjMatrix[from][to];
                    transDist[to] = transDist[from] + 1;
                    queue.add(to);
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= numLang; i++) {
            if (costs[i] == Integer.MAX_VALUE) {
                System.out.println("Impossible");
                return;
            }
            result += costs[i];
        }
        System.out.println(result);
    }

}
