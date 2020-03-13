import java.util.Scanner;

class ants {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();

        while (numCase-- > 0) {
            int len = in.nextInt();
            int n = in.nextInt();

            int shortest = 0, longest = 0;
            for (int i = 0; i < n; i++) {
                int pos = in.nextInt();

                shortest = Math.max(shortest, Math.min(pos, len - pos));
                longest = Math.max(longest, Math.max(pos, len - pos));
            }

            System.out.println(shortest + " " + longest);
        }
    }
}
