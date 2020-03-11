
import java.util.*;

public class pot {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int total = 0;
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int value = in.nextInt();

            int pow = value % 10;
            int num = value / 10;

            total += Math.pow(num, pow);
        }

        System.out.println(total);
    }
}
