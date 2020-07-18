import java.util.Scanner;

class nineknights {
    static int[] xPos = new int[] { -1, 1, -2, 2 };
    static int[][] yPos = new int[][] { { -2, 2 }, { -2, 2 }, { -1, 1 }, { -1, 1 } };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[][] matrix = new char[5][5];
        for (int i = 0; i < 5; i++) {
            matrix[i] = in.next().toCharArray();
        }

        boolean valid = true;
        int count = 0;
        outer: for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == '.')
                    continue;

                count++;
                for (int k = 0; k < 4; k++) {
                    int x = i + xPos[k];
                    if (x < 0 || x >= 5)
                        continue;

                    for (int g = 0; g < 2; g++) {
                        int y = j + yPos[k][g];
                        if (y < 0 || y >= 5)
                            continue;

                        if (matrix[x][y] == 'k') {
                            valid = false;
                            break outer;
                        }
                    }
                }
            }
        }

        System.out.println((valid && count == 9) ? "valid" : "invalid");

    }
}
