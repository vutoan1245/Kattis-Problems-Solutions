import java.util.Scanner;
import java.util.ArrayList;

class mazemakers {
    static ArrayList<ArrayList<Integer>> adjList;
    static boolean visited[], open[];
    static boolean ok, unreachable, multiple;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int rows = in.nextInt();
            int cols = in.nextInt();

            if (rows == 0 && cols == 0) {
                break;
            }

            char[][] matrix = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                matrix[i] = in.next().toCharArray();
            }

            int size = rows * cols;
            open = new boolean[size];
            adjList = new ArrayList<ArrayList<Integer>>(size);

            for (int i = 0; i < size; i++) {
                adjList.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int index = i * cols + j;
                    int value = Integer.parseInt(matrix[i][j] + "", 16);

                    for (int k = 3; k >= 0; k--) {
                        if ((1 & (value >> k)) == 0) {
                            int r = i;
                            int c = j;

                            switch (k) {
                                case 3:
                                    r--;
                                    break;
                                case 2:
                                    c++;
                                    break;
                                case 1:
                                    r++;
                                    break;
                                case 0:
                                    c--;
                                    break;
                            }

                            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                                open[index] = true;
                            } else {
                                adjList.get(index).add(r * cols + c);
                            }
                        }
                    }
                }
            }

            ok = false;
            multiple = false;
            unreachable = false;
            visited = new boolean[size];

            for (int i = 0; i < size; i++) {
                if (open[i]) {
                    visited[i] = true;
                    dfs(i, -1);
                    break;
                }
            }
            for (int i = 0; i < size; i++) {
                if (!visited[i]) {
                    unreachable = true;
                }
            }

            if (!ok) {
                System.out.println("NO SOLUTION");
            } else if (unreachable) {
                System.out.println("UNREACHABLE CELL");
            } else if (multiple) {
                System.out.println("MULTIPLE PATHS");
            } else {
                System.out.println("MAZE OK");
            }

        }

    }

    public static void dfs(int index, int prev) {
        if (!visited[index] && open[index]) {
            ok = true;
        }
        visited[index] = true;

        for (int next : adjList.get(index)) {
            if (next == prev) {
                continue;
            }
            if (visited[next]) {
                multiple = true;
                continue;
            }

            dfs(next, index);
        }
    }
}
