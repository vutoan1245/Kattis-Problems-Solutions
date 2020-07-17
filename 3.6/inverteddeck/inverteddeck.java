import java.util.Scanner;

class inverteddeck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCards = in.nextInt();
        int[] cards = new int[numCards];
        for (int i = 0; i < numCards; i++) {
            cards[i] = in.nextInt();
        }

        int start = 0, end = 0;
        int count = 0;
        boolean impossible = false;

        for (int i = 1; i < numCards; i++) {
            if (cards[i] < cards[i - 1]) {
                count++;
                if (count > 1) {
                    impossible = true;
                    break;
                }

                start = i - 1;
                for (; i < numCards; i++) {
                    if (cards[i] <= cards[i - 1]) {
                        end = i;
                    } else {
                        i--;
                        break;
                    }
                }
            }
        }

        while (start > 0 && cards[start] == cards[start - 1])
            start--;

        if (start > 0 && cards[end] < cards[start - 1])
            impossible = true;
        if (end < numCards - 1 && cards[start] > cards[end + 1])
            impossible = true;

        if (impossible) {
            System.out.println("impossible");
        } else {
            System.out.printf("%d %d\n", start + 1, end + 1);
        }
    }
}
