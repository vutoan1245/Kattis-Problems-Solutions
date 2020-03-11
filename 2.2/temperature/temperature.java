import java.util.Scanner;

class temperature {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int b1 = in.nextInt();
        int ratio = in.nextInt();

        if (ratio == 1 && b1 != 0) {
            System.out.println("IMPOSSIBLE");
        } else if (ratio == 1 && b1 == 0) {
            System.out.println("ALL GOOD");
        } else {
            System.out.println(-1.0 * b1 / (ratio - 1));
        }
    }
}
