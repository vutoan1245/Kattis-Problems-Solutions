import java.util.Scanner;

class jollyjumpers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            boolean jolly = true;
            int n = in.nextInt();
            boolean[] visited = new boolean[n];

            int cur = in.nextInt();
            for (int i = 1; i < n; i++) {
                int next = in.nextInt();
                int diff = Math.abs(next - cur);
                if (diff <= 0 || diff >= n || visited[diff]) {
                    jolly = false;
                    continue;
                }

                visited[diff] = true;
                cur = next;
            }

            System.out.println(jolly ? "Jolly" : "Not jolly");
        }
    }
}
