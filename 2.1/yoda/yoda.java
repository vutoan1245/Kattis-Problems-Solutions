import java.util.Scanner;

class yoda {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String num1 = in.next();
        String num2 = in.next();

        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }
        while (num2.length() < num1.length()) {
            num2 = "0" + num2;
        }

        String result1 = "", result2 = "";
        int size = num1.length();
        for (int i = 0; i < size; i++) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            if (digit1 == digit2) {
                result1 += digit1;
                result2 += digit2;
            } else if (digit1 > digit2) {
                result1 += digit1;
            } else {
                result2 += digit2;
            }
        }

        System.out.println(result1.equals("") ? "YODA" : Integer.parseInt(result1));
        System.out.println(result2.equals("") ? "YODA" : Integer.parseInt(result2));

    }
}
