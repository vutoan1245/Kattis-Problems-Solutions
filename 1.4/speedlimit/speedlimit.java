import java.util.Scanner;

class speedlimit {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n;
        while ((n = in.nextInt()) != -1) {
            int total = 0, prevTime = 0;

            for (int i = 0; i < n; i++) {
                int speed = in.nextInt();
                int time = in.nextInt();

                total += speed * (time - prevTime);

                prevTime = time;
            }

            System.out.println(total + " miles");
        }
    }
}
