import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char value = expression.charAt(i);
            if (value == '(' || value == '[') {
                stack.push(String.valueOf(value));
            } else if (value == ')') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("2");
                } else {
                    int op = 0;
                    while (!stack.isEmpty() && isNumber(stack.peek())) {
                        op += Integer.parseInt(stack.pop());
                    }

                    if (stack.isEmpty() || !stack.peek().equals("(")) { // 괄호 짝 안 맞음
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    stack.push(String.valueOf(op * 2));
                }
            } else if (value == ']') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                if (stack.peek().equals("[")) {
                    stack.pop();
                    stack.push("3");
                } else {
                    int op = 0;
                    while (!stack.isEmpty() && isNumber(stack.peek())) {
                        op += Integer.parseInt(stack.pop());
                    }

                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    stack.push(String.valueOf(op * 3));
                }
            } else {
                System.out.println(0);
                return;
            }
        }

        int result = 0;
        for(String v : stack) {
            if (!isNumber(v)) {
                System.out.println(0);
                return;
            }
            result += Integer.parseInt(v);
        }
        System.out.println(result);
    }

    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}