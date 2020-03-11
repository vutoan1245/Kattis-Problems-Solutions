import java.util.Scanner;

class zamka {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int l = in.nextInt();
        int d = in.nextInt();
        int x = in.nextInt();

        System.out.println(findN(l, d, x));
        System.out.println(findM(l, d, x));
    }

    public static int findN(int l, int d, int x) {
        for (int i = l; i <= d; i++) {
            if (sumDigits(i) == x) {
                return i;
            }
        }

        return -1;
    }

    public static int findM(int l, int d, int x) {
        for (int i = d; i >= l; i--) {
            if (sumDigits(i) == x) {
                return i;
            }
        }

        return -1;
    }

    public static int sumDigits(int num) {
        String str = "" + num;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            result += (str.charAt(i) - '0');
        }

        return result;
    }
}
