import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inversefactorial {
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        int len = line.length();

        if (line.equals("1")) {
            System.out.println("1");
        } else if (line.equals("2")) {
            System.out.println("2");
        } else if (line.equals("6")) {
            System.out.println("3");
        } else {
            // Find len of n!
            for (int n = 2; n <= MAX; n++) {
                int nFacLen = (int) (n * Math.log10(n / Math.E) + Math.log10(2 * Math.PI * n) / 2) + 1;

                if (nFacLen >= len) {
                    System.out.println(n);
                    break;
                }
            }
        }
    }

}
