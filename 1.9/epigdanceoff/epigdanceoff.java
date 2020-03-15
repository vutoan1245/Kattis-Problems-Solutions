import java.util.Scanner;

class epigdanceoff {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int rows = in.nextInt();
        int cols = in.nextInt();

        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = in.next().toCharArray();
        }

        int result = 0;

        for (int i = 0; i < cols; i++) {
            boolean isBlank = true;
            for (int j = 0; j < rows; j++) {
                if (matrix[j][i] == '$') {
                    isBlank = false;
                }
            }
            if (isBlank) {
                result++;
            }
        }

        System.out.println(result + 1);
    }

}
