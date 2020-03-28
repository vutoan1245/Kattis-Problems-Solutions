import java.util.*;

public class cardtrick2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int caseNum = in.nextInt();
        for (int i = 0; i < caseNum; i++) {
            int n = in.nextInt();
            int[] cards = new int[n];

            int index = 1 % n;
            cards[index] = 1;
            for (int next = 2; next <= n; next++) {
                for (int j = 0; j <= next; j++) {
                    index = (index + 1) % n;
                    while (cards[index] != 0) {
                        index = (index + 1) % n;
                    }
                }
                cards[index] = next;
            }

            StringBuilder result = new StringBuilder();
            for (int num : cards) {
                result.append(num + " ");
            }

            System.out.println(result.toString().trim());
        }
    }
}
