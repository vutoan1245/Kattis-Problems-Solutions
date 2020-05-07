import java.util.PriorityQueue;
import java.util.Scanner;

class downtime {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] requests = new int[n];
        for (int i = 0; i < n; i++) {
            requests[i] = in.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numProcess = k;
        for (int i = 0; i < n; i++) {
            int time = requests[i];

            if (pq.size() < numProcess) {
                pq.add(time);
            } else {
                if (time >= pq.peek() + 1000) {
                    pq.poll();
                    pq.add(time);
                } else {
                    numProcess += k;
                    pq.add(time);
                }
            }
        }

        System.out.println(numProcess / k);
    }

}
