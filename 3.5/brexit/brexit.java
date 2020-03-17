import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class brexit {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCountry = in.nextInt();
        int numEdge = in.nextInt();
        int target = in.nextInt() - 1;
        int first = in.nextInt() - 1;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(numCountry);
        for (int i = 0; i < numCountry; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < numEdge; i++) {
            int n1 = in.nextInt() - 1;
            int n2 = in.nextInt() - 1;

            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }

        int[] leftCount = new int[numCountry];
        boolean[] visited = new boolean[numCountry];
        Queue<Integer> leftList = new LinkedList<Integer>();
        leftList.add(first);

        boolean stay = true;
        while (!leftList.isEmpty()) {
            int cur = leftList.poll();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;

            if (cur == target) {
                stay = false;
                break;
            }

            for (int next : adjList.get(cur)) {
                if (visited[next]) {
                    continue;
                }

                leftCount[next]++;
                if (leftCount[next] * 2 >= adjList.get(next).size()) {
                    leftList.add(next);
                }
            }
        }

        System.out.println(stay ? "stay" : "leave");
    }
}
