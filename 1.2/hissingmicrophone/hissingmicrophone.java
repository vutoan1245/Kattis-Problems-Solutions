import java.util.Scanner;

class hissingmicrophone {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        boolean found = false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == 's' && str.charAt(i) == 's') {
                found = true;
                break;
            }
        }

        System.out.println(found ? "hiss" : "no hiss");
    }
}
