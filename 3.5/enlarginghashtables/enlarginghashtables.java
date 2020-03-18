import java.util.*;

public class enlarginghashtables {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;
        while ((n = in.nextInt()) != 0) {
            boolean nIsPrime = isPrime(n);
            int result = 2 * n;

            while (!isPrime(++result)) {
            }

            if (nIsPrime) {
                System.out.println(result);
            } else {
                System.out.println(result + " (" + n + " is not prime)");
            }
        }
    }

    static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
