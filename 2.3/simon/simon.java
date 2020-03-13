import java.util.Scanner;

class simon {
    public static void main(String arsg[]) {
        Scanner in = new Scanner(System.in);

        int numCase = Integer.parseInt(in.nextLine());

        while (numCase-- > 0) {
            String[] strArr = in.nextLine().split(" ");

            int i = 1;
            for (; i < strArr.length; i++) {
                if (strArr[i - 1].equals("simon") && strArr[i].equals("says")) {
                    break;
                }
            }

            String result = "";
            for (i++; i < strArr.length; i++) {
                result += strArr[i] + " ";
            }

            System.out.println(result.trim());
        }
    }
}
