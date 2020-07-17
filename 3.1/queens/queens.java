import java.util.Scanner;

// https://open.kattis.com/problems/queens
class queens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        boolean[] hor = new boolean[n];
        boolean[] ver = new boolean[n];
        boolean[] dig1 = new boolean[n * 2 - 1];
        boolean[] dig2 = new boolean[n * 2 - 1];

        boolean correct = true;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int d1 = x + y;
            int d2 = (n - 1 - x) + y;

            if (hor[x] || ver[y] || dig1[d1] || dig2[d2]) {
                correct = false;
                break;
            } else {
                hor[x] = true;
                ver[y] = true;
                dig1[d1] = true;
                dig2[d2] = true;
            }
        }

        System.out.println(correct ? "CORRECT" : "INCORRECT");
    }
}
