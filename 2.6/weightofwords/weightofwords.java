import java.util.Scanner;

class weightofwords {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int length = in.nextInt();
        int weight = in.nextInt();

        String result = findWord(length, weight);
        System.out.println(result);
    }

    static String findWord(int l, int w) {
        int average = (int) Math.ceil(1.0 * w / l);
        if (l > w || average > 26)
            return "impossible";
        if (l == 1)
            return Character.toString(w - 1 + 'a');

        return Character.toString(average - 1 + 'a') + findWord(l - 1, w - average);
    }
}
