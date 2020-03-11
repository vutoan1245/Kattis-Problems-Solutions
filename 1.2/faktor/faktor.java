import java.util.Scanner;

class faktor {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numArticle = in.nextInt();
        int targetRatio = in.nextInt();

        int result = (targetRatio - 1) * numArticle + 1;

        System.out.println(result);
    }
}
