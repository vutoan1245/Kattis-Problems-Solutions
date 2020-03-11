import java.util.Scanner;

class whichbase {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();

        while (numCase-- > 0) {
            int id = in.nextInt();
            String num = in.next();

            System.out.printf("%d %d %d %d\n", id, convertBase(num, 8), convertBase(num, 10), convertBase(num, 16));

        }
    }

    public static int convertBase(String num, int base) {
        try {
            return Integer.parseInt(num, base);
        } catch (Exception e) {
            return 0;
        }
    }
}
