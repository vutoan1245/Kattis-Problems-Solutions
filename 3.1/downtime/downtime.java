import java.util.PriorityQueue;
import java.util.Scanner;

class downtime {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numRequests = in.nextInt();
        int requestPerServer = in.nextInt();

        PriorityQueue<Integer> server = new PriorityQueue<>();
        for (int i = 0; i < requestPerServer; i++) {
            server.add(0);
        }

        for (int i = 0; i < numRequests; i++) {
            int time = in.nextInt();
            if (server.peek() > time) {
                for (int j = 0; j < requestPerServer; j++) {
                    server.add(0);
                }
            }
            server.poll();
            server.add(time + 1000);
        }

        System.out.println(server.size() / requestPerServer);
    }
}
