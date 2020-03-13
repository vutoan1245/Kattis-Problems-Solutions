import java.util.*;

class abc {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        String str = in.next();
        for (int i = 0; i < 3; i++) {
            System.out.print(arr[str.charAt(i) - 'A'] + " ");
        }
        System.out.println();
    }
}
