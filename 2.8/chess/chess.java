import java.util.Scanner;

// https://open.kattis.com/problems/chess
class chess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCases = in.nextInt();

        while (numCases-- > 0) {
            int x1 = in.next().charAt(0) - 'A' + 1;
            int y1 = in.nextInt();
            int x2 = in.next().charAt(0) - 'A' + 1;
            int y2 = in.nextInt();

            if ((x1 + y1) % 2 != (x2 + y2) % 2) {
                System.out.println("Impossible");
                continue;
            }

            if (x1 == x2 && y1 == y2) {
                System.out.printf("%d %c %d\n", 0, (char) (x1 + 'A' - 1), y1);
                continue;
            }

            int d1 = x1 + y1 - 1;
            int d2 = (8 - x1) + y1;
            int e1 = x2 + y2 - 1;
            int e2 = (8 - x2) + y2;

            if (d1 == e1 || d2 == e2) {
                System.out.printf("%d %c %d %c %d\n", 1, (char) (x1 + 'A' - 1), y1, (char) (x2 + 'A' - 1), y2);
                continue;

            }

            int mid1 = (((d1 + 1) - (e2 - 8)) / 2);
            int mid2 = (((d1 + 1) + (e2 - 8)) / 2);

            if (mid1 <= 0 || mid1 > 8 || mid2 <= 0 || mid2 > 8) {
                mid1 = (((e1 + 1) - (d2 - 8)) / 2);
                mid2 = (((e1 + 1) + (d2 - 8)) / 2);
            }

            System.out.printf("%d %c %d %c %d %c %d\n", 2, (char) (x1 + 'A' - 1), y1, (char) (mid1 + 'A' - 1), mid2,
                    (char) (x2 + 'A' - 1), y2);
        }
    }
}
