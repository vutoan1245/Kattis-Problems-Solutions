import java.util.HashMap;
import java.util.Scanner;

class thought {
    static final int INVALID = 10000000;
    static char[] ops = { '*', '+', '-', '/' };
    static HashMap<Integer, String> mapValueToExp = new HashMap<Integer, String>();

    public static void main(String[] args) {

        for (char op1 : ops) {
            for (char op2 : ops) {
                for (char op3 : ops) {
                    String expression = "4 " + op1 + " 4 " + op2 + " 4 " + op3 + " 4";

                    int value = 0;
                    if (!special(op1) && special(op2) && special(op3)) {
                        value = operation(4, op1, operation(operation(4, op2, 4), op3, 4));
                    } else if (!special(op2) && special(op3)) {
                        value = operation(operation(4, op1, 4), op2, operation(4, op3, 4));
                    } else if (!special(op1) && special(op2) && !special(op3)) {
                        value = operation(operation(4, op1, operation(4, op2, 4)), op3, 4);
                    } else {
                        value = operation(operation(operation(4, op1, 4), op2, 4), op3, 4);
                    }

                    if (!mapValueToExp.containsKey(value)) {
                        mapValueToExp.put(value, expression);
                    }
                }
            }
        }

        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        while (numCase-- > 0) {
            int n = in.nextInt();
            String result = mapValueToExp.get(n);

            if (result != null) {
                System.out.println(result + " = " + n);
            } else {
                System.out.println("no solution");
            }
        }
    }

    static boolean special(char op) {
        return op == '*' || op == '/';
    }

    static int operation(int a, char op, int b) {
        switch (op) {
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    return INVALID;
                return a / b;
            case '+':
                return a + b;
            case '-':
                return a - b;
        }

        return INVALID;
    }
}
