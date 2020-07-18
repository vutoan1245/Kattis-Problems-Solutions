import java.util.Scanner;

// https://open.kattis.com/problems/imageprocessing
class imageprocessing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int iRows = in.nextInt();
        int iCols = in.nextInt();
        int kRows = in.nextInt();
        int kCols = in.nextInt();

        int[][] image = new int[iRows][iCols];
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                image[i][j] = in.nextInt();
            }
        }
        int[][] kernel = new int[kRows][kCols];
        for (int i = kRows - 1; i >= 0; i--) {
            for (int j = kCols - 1; j >= 0; j--) {
                kernel[i][j] = in.nextInt();
            }
        }

        for (int i = kRows; i <= iRows; i++) {
            for (int j = kCols; j <= iCols; j++) {
                int val = 0;
                for (int k = 0; k < kRows; k++) {
                    for (int g = 0; g < kCols; g++) {
                        int x = i - kRows + k;
                        int y = j - kCols + g;

                        val += image[x][y] * kernel[k][g];
                    }
                }

                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
