import java.util.Scanner;

class stararrangements {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numStar = in.nextInt();

        System.out.println(numStar + ":");

        for (int i = 2; i < numStar; i++) {
            if (validate(i, i - 1, numStar)) {
                System.out.printf("%d,%d\n", i, i - 1);
            }
            if (validate(i, i, numStar)) {
                System.out.printf("%d,%d\n", i, i);
            }
        }
    }

    public static boolean validate(int row1, int row2, int numStar) {
        int sum = row1 + row2;
        int numRow = (numStar / sum) * 2;
        if (numStar % sum != 0)
            numRow++;

        int numRow1 = numRow - (numRow / 2);
        int numRow2 = numRow - numRow1;

        return row1 * numRow1 + row2 * numRow2 == numStar;
    }
}
