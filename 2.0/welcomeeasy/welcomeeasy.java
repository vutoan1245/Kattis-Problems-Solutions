import java.util.Scanner;

public class welcomeeasy {

    static char[] target = "welcome to code jam".toCharArray();
    static char[] charArr;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int numCase = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= numCase; t++) {
            charArr = in.nextLine().toCharArray();
            System.out.printf("Case #%d: %04d \n", t, find(0, 0));
        }
    }

    static int find(int curIndex, int targetIndex) {
        if (targetIndex == target.length) {
            return 1;
        }
        if (curIndex == charArr.length) {
            return 0;
        }

        int result = find(curIndex + 1, targetIndex);
        if (target[targetIndex] == charArr[curIndex]) {
            result += find(curIndex + 1, targetIndex + 1);
        }

        return result;
    }
}
