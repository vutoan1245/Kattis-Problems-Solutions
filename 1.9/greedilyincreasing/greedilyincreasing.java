import java.util.Scanner;

class greedilyincreasing {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int cur = arr[0], size = 1;
        StringBuilder result = new StringBuilder(Integer.toString(cur));
        for (int i = 1; i < n; i++) {
            if (arr[i] > cur) {
                cur = arr[i];
                size++;
                result.append(" " + cur);
            }
        }

        System.out.println(size);
        System.out.println(result.toString());
    }
}
