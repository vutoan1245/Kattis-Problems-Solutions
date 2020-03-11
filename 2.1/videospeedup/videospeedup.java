import java.util.Scanner;

class videospeedup {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numSegment = in.nextInt();
        int speedup = in.nextInt();
        int totalTime = in.nextInt();

        double result = 0.0, speed = 1.0;
        int prevTime = 0;

        for (int i = 0; i < numSegment; i++) {
            int curTime = in.nextInt();

            speed = (100 + i * speedup) / 100.0;
            result += (curTime - prevTime) * speed;

            prevTime = curTime;
        }

        speed = (100 + numSegment * speedup) / 100.0;
        result += (totalTime - prevTime) * speed;

        System.out.println(result);
    }
}
