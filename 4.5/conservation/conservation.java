import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class conservation {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();

        for (int t = 0; t < numCase; t++) {
            int numStage = in.nextInt();
            int numEdge = in.nextInt();

            int[] group = new int[numStage];
            for (int i = 0; i < numStage; i++) {
                group[i] = in.nextInt() == 1 ? 1 : 2;
            }

            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(numStage);
            for (int i = 0; i < numStage; i++) {
                adjList.add(new ArrayList<Integer>());
            }

            int[] parent = new int[numStage];

            for (int i = 0; i < numEdge; i++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;

                adjList.get(from).add(to);
                parent[to]++;
            }

            int cost1 = findCost(numStage, copyArr(parent), adjList, group, 1);
            int cost2 = findCost(numStage, copyArr(parent), adjList, group, 2);

            System.out.println(Math.min(cost1, cost2));

        }

    }

    static int[] copyArr(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    static int findCost(int numStage, int[] parent, ArrayList<ArrayList<Integer>> adjList, int[] group,
            int startGroup) {

        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();

        for (int i = 0; i < numStage; i++) {
            if (parent[i] == 0) {
                if (group[i] == 1) {
                    queue1.add(i);
                } else {
                    queue2.add(i);
                }
            }
        }

        Queue<Integer> curr = startGroup == 1 ? queue1 : queue2;
        int count = 0;
        int cost = 0;

        while (count < numStage) {
            cost++;

            while (!curr.isEmpty()) {
                int index = curr.poll();
                count++;
                for (int next : adjList.get(index)) {
                    parent[next]--;
                    if (parent[next] == 0) {
                        if (group[next] == 1) {
                            queue1.add(next);
                        } else {
                            queue2.add(next);
                        }
                    }
                }
            }

            curr = curr == queue1 ? queue2 : queue1;
        }

        return cost - 1;
    }

}
