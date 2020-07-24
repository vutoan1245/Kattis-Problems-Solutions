import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://open.kattis.com/problems/elevatortrouble
class elevatortrouble {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numFloors = in.nextInt();
        int start = in.nextInt();
        int goal = in.nextInt();
        int u = in.nextInt();
        int d = in.nextInt();

        int[] floors = new int[numFloors + 1];
        for (int i = 0; i <= numFloors; i++) {
            floors[i] = -1;
        }
        floors[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> next = new LinkedList<>();
        queue.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            step++;

            while (!queue.isEmpty()) {
                int curFloor = queue.poll();

                if (curFloor + u <= numFloors && floors[curFloor + u] == -1) {
                    floors[curFloor + u] = step;
                    next.add(curFloor + u);
                }
                if (curFloor - d > 0 && floors[curFloor - d] == -1) {
                    floors[curFloor - d] = step;
                    next.add(curFloor - d);
                }
            }

            queue = next;
            next = new LinkedList<>();
        }

        System.out.println(floors[goal] != -1 ? floors[goal] : "use the stairs");
    }
}
