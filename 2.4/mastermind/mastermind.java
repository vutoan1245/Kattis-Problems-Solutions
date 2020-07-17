import java.util.HashMap;
import java.util.Scanner;

// https://open.kattis.com/problems/mastermind
class mastermind {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int len = in.nextInt();

        String code = in.next();
        String guess = in.next();

        HashMap<Character, Integer> codeMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> guessMap = new HashMap<Character, Integer>();

        int r = 0, s = 0;
        for (int i = 0; i < len; i++) {
            if (code.charAt(i) == guess.charAt(i)) {
                r++;
            } else {
                codeMap.put(code.charAt(i), codeMap.getOrDefault(code.charAt(i), 0) + 1);
                guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }
        for (char c : codeMap.keySet()) {
            s += Math.min(codeMap.get(c), guessMap.getOrDefault(c, 0));
        }

        System.out.println(r + " " + s);
    }
}
