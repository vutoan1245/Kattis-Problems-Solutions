import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// https://open.kattis.com/problems/rockband
class rockband {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numMembers = in.nextInt();
        int numSongs = in.nextInt();

        int[][] arr = new int[numMembers][numSongs];
        int[][] pos = new int[numMembers][numSongs];
        boolean[] added = new boolean[numSongs + 1];

        for (int i = 0; i < numMembers; i++) {
            for (int j = 0; j < numSongs; j++) {
                int value = in.nextInt();
                arr[i][j] = value;
                pos[i][value - 1] = j;
            }
        }

        PriorityQueue<Integer> result = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numMembers; i++) {
            int value = arr[i][0];

            if (!added[value]) {
                result.add(value);
                queue.add(value);
                added[value] = true;
            }
        }

        int[] reach = new int[numMembers];
        while (!queue.isEmpty()) {
            int value = queue.poll();
            for (int i = 0; i < numMembers; i++) {
                int p = pos[i][value - 1];

                if (reach[i] < p) {
                    for (int j = reach[i] + 1; j <= p; j++) {
                        int next = arr[i][j];
                        if (!added[next]) {
                            added[next] = true;
                            queue.add(next);
                            result.add(next);
                        }
                    }
                    reach[i] = p;
                }
            }
        }

        // Print output
        System.out.println(result.size());
        while (!result.isEmpty()) {
            System.out.print(result.poll() + " ");
        }
        System.out.println();
    }

}
