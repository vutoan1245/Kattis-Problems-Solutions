import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://open.kattis.com/problems/flipfive
class flipfive {
    static int[] dx = new int[] { 0, -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCases = in.nextInt();

        Queue<String> queue = new LinkedList<>();
        Queue<String> nextQueue = new LinkedList<>();
        queue.add("000000000");

        HashMap<String, Integer> map = new HashMap<>();
        map.put("000000000", 0);

        // Find result for all possible cases
        int step = 0;
        while (!queue.isEmpty()) {
            step++;

            while (!queue.isEmpty()) {
                String cur = queue.poll();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        boolean[][] matrix = stringToMatrix(cur);

                        for (int k = 0; k < 5; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];

                            if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                                matrix[x][y] = !matrix[x][y];
                            }
                        }

                        String next = matrixToString(matrix);
                        if (!map.containsKey(next)) {
                            map.put(next, step);
                            nextQueue.add(next);
                        }
                    }
                }
            }

            queue = nextQueue;
            nextQueue = new LinkedList<>();
        }

        while (numCases-- > 0) {
            boolean[][] matrix = new boolean[3][3];
            for (int i = 0; i < 3; i++) {
                String line = in.next();
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = line.charAt(j) == '*';
                }
            }

            String str = matrixToString(matrix);
            System.out.println(map.get(str));
        }
    }

    static String matrixToString(boolean[][] matrix) {
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += matrix[i][j] ? "1" : "0";
            }
        }

        return result;
    }

    static boolean[][] stringToMatrix(String str) {
        boolean[][] matrix = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int p = i * 3 + j;
                matrix[i][j] = str.charAt(p) == '1';
            }
        }

        return matrix;
    }
}
