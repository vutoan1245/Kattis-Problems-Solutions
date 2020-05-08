import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class horror {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numMovie = in.nextInt();
        int numHorror = in.nextInt();
        int numRelated = in.nextInt();

        int[] scores = new int[numMovie];
        Arrays.fill(scores, INF);
        for (int i = 0; i < numHorror; i++) {
            scores[in.nextInt()] = 0;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(numMovie);
        for (int i = 0; i < numMovie; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < numRelated; i++) {
            int id1 = in.nextInt();
            int id2 = in.nextInt();
            adjList.get(id1).add(id2);
            adjList.get(id2).add(id1);
        }

        for (int i = 0; i < numMovie; i++) {
            if (scores[i] == 0)
                dfs(i, 1, scores, adjList);
        }

        int maxScore = -1, result = -1;
        for (int i = 0; i < numMovie; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                result = i;
            }
        }

        System.out.println(result);

    }

    static void dfs(int index, int s, int[] scores, ArrayList<ArrayList<Integer>> adjList) {
        for (int next : adjList.get(index)) {
            if (scores[next] <= s)
                continue;
            scores[next] = s;
            dfs(next, s + 1, scores, adjList);
        }
    }
}
