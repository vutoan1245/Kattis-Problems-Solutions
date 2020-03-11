import java.util.Scanner;

class tarifa {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int limit = in.nextInt();
        int n = in.nextInt();

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += limit;
            result -= in.nextInt();
            result = Math.max(result, 0);
        }

        System.out.println(result + limit);
    }
}
