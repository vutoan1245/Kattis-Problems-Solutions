import java.util.Scanner;

class wordsfornumbers {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String result = "";
            for (String str : in.nextLine().split(" ")) {
                if (!isNumeric(str)) {
                    result += str + " ";
                } else {
                    result += convertToStr(str) + " ";
                }
            }

            result = result.substring(0, 1).toUpperCase() + result.substring(1);
            System.out.println(result.trim());
        }
    }

    public static String convertToStr(String num) {
        switch (num) {
            case "0":
                return "zero";
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
            case "10":
                return "ten";
            case "11":
                return "eleven";
            case "12":
                return "twelve";
            case "13":
                return "thirteen";
            case "14":
                return "fourteen";
            case "15":
                return "fifteen";
            case "16":
                return "sixteen";
            case "17":
                return "seventeen";
            case "18":
                return "eighteen";
            case "19":
                return "nineteen";
        }

        String result = "";
        switch (num.charAt(0)) {
            case '2':
                result = "twenty";
                break;
            case '3':
                result = "thirty";
                break;
            case '4':
                result = "forty";
                break;
            case '5':
                result = "fifty";
                break;
            case '6':
                result = "sixty";
                break;
            case '7':
                result = "seventy";
                break;
            case '8':
                result = "eighty";
                break;
            case '9':
                result = "ninety";
                break;
        }

        String other = convertToStr(num.substring(1));
        if (!other.equals("zero")) {
            result += "-" + other;
        }

        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
