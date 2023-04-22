package org.example.stack;

public class PostfixEval {
    public static void main(String[] args) {
        String postFix = "700 3 47 + 6 * - 4 /";
        System.out.println("postFix = " + postFix);
        int answer = evaluate(postFix);
        System.out.println("answer = " + answer);
    }

    private static int evaluate(String postFix) {
        int A, B;

        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        boolean isDigitPreviously = false;

        for (int i = 0; i < postFix.length(); i++) {
            char ch = postFix.charAt(i);

            if (Character.isDigit(ch)) {
                if (isDigitPreviously) {
                    int temp = linkedStack.pop();
                    temp = 10 * temp + (ch - '0');
                    linkedStack.push(temp);
                } else {
                    linkedStack.push(ch - '0');
                    isDigitPreviously = true;
                }

            } else if (isOperator(ch)) {
                A = linkedStack.pop();
                B = linkedStack.pop();
                int operatedValue = operation(A, B, ch);
                linkedStack.push(operatedValue);
                isDigitPreviously = false;
            } else isDigitPreviously = false;

        }

        return linkedStack.pop();
    }

    private static int operation(int a, int b, char ch) {
        int val = 0;
        switch (ch) {
            case '*':
                val = b * a;
                break;
            case '/':
                val = b / a;
                break;
            case '+':
                val = b + a;
                break;
            case '-':
                val = b - a;
                break;
        }
        return val;
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '*' || ch == '-' || ch == '/';
    }
}
