import java.util.Scanner;

class trik {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        int[] cup = new int[3];
        cup[0] = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                swap(cup, 0, 1);
            } else if (str.charAt(i) == 'B') {
                swap(cup, 1, 2);
            } else {
                swap(cup, 0, 2);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cup[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;

    }
}
