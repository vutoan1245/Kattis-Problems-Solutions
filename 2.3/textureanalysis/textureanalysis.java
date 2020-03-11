import java.util.Scanner;

class textureanalysis {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int caseCount = 1;
        while (true) {
            String line = in.next();
            if (line.equals("END")) {
                break;
            }

            int len = line.length();

            String pattern = "";
            int index = 1;
            while (index < len && line.charAt(index) == '.') {
                pattern += '.';
                index++;
            }

            boolean even = true;
            int i = 1;
            while (i < len) {

                if (len - i < pattern.length()) {
                    even = false;
                    break;
                }

                String match = line.substring(i, i + pattern.length());
                if (!match.equals(pattern)) {
                    even = false;
                    break;
                }
                i += pattern.length();

                if (i == len || line.charAt(i) != '*') {
                    even = false;
                    break;
                }
                i++;
            }

            System.out.println(caseCount++ + " " + (even ? "EVEN" : "NOT EVEN"));
        }
    }
}
