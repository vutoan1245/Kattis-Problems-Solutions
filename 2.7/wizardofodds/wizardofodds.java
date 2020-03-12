import java.math.BigInteger;
import java.util.Scanner;

class wizardofodds {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        BigInteger n = new BigInteger(in.next());
        BigInteger k = new BigInteger(in.next());

        System.out.println((new BigInteger("2")).pow(k.intValue()).compareTo(n) < 0 ? "You will become a flying monkey!"
                : "Your wish is granted!");

    }
}
