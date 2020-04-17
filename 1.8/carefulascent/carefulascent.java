import java.util.Scanner;

public class carefulascent {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        int n = in.nextInt();

        int curY = 0;
        double f = 0.0;

        for (int i = 0; i < n; i++) {
            int lower = in.nextInt();
            int upper = in.nextInt();
            double factor = in.nextDouble();

            curY += (upper - lower);
            f += (upper - lower) * factor;
        }

        f += (y - curY);

        System.out.println((x / f));
    }

}
