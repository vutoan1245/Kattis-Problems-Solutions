import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class buttonbashing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();

        while (numCase-- > 0) {
            int numButton = in.nextInt();
            int[] buttonList = new int[numButton];
            int target = in.nextInt();
            for (int i = 0; i < numButton; i++) {
                buttonList[i] = in.nextInt();
            }

            HashSet<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> next = new LinkedList<>();
            queue.add(0);
            set.add(0);

            int step = 0;
            int nextHigher = Integer.MAX_VALUE, numPress = 0;
            outer: while (!queue.isEmpty()) {

                while (!queue.isEmpty()) {
                    int time = queue.poll();
                    if (time == target) {
                        nextHigher = time;
                        numPress = step;
                        break outer;
                    }
                    if (time > target) {
                        if (time < nextHigher) {
                            nextHigher = time;
                            numPress = step;
                        }
                    }
                    for (int i = 0; i < numButton; i++) {
                        int nextTime = time + buttonList[i];
                        if (nextTime < 0)
                            nextTime = 0;
                        if (nextTime > 3600)
                            nextTime = 3600;

                        if (!set.contains(nextTime)) {
                            next.add(nextTime);
                            set.add(nextTime);
                        }
                    }
                }

                step++;
                queue = next;
                next = new LinkedList<>();
            }

            System.out.println(numPress + " " + (nextHigher - target));
        }
    }
}
