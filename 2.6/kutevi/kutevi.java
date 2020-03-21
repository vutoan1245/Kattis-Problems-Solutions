import java.util.Scanner;

class kutevi {
    static int n, k;
    static int[] angle;
    static int[] possible = new int[360];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();
        angle = new int[n];
        for (int i = 0; i < n; i++) {
            angle[i] = in.nextInt();
            possible[angle[i]] = 1;
        }

        for (int j = 0; j < k; j++) {
            System.out.println(isPossible(in.nextInt()) ? "YES" : "NO");
        }
    }

    static boolean isPossible(int a) {
        if (possible[a] != 0) {
            return possible[a] == 1;
        }
        possible[a] = -1;

        boolean result = false;
        for (int i = 0; i < n; i++) {
            result |= isPossible((a + angle[i]) % 360);
            if (result)
                break;
            result |= isPossible((a + 360 - angle[i]) % 360);
            if (result)
                break;
        }

        possible[a] = result ? 1 : -1;
        return result;
    }
}
