import java.util.Arrays;
import java.util.Scanner;

class cups {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        Cup[] cupList = new Cup[n];
        for (int i = 0; i < n; i++) {
            String[] strArr = in.nextLine().split(" ");

            int radius;
            String color;

            if (isNumeric(strArr[0])) {
                radius = Integer.parseInt(strArr[0]) / 2;
                color = strArr[1];
            } else {
                radius = Integer.parseInt(strArr[1]);
                color = strArr[0];
            }

            cupList[i] = new Cup(radius, color);
        }

        Arrays.sort(cupList);

        for (int i = 0; i < n; i++) {
            System.out.println(cupList[i].color);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class Cup implements Comparable<Cup> {
    int radius;
    String color;

    Cup(int r, String c) {
        radius = r;
        color = c;
    }

    public int compareTo(Cup o) {
        return radius - o.radius;
    }

}
