import java.util.Scanner;

class autori {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        for (String s : str.split("-")) {
            System.out.print(s.charAt(0));
        }
    }
}
