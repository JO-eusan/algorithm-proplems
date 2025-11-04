import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String curves = br.readLine();

        Stack<Character> stack = new Stack<>();
        int counter = 0;
        for(int i = 0; i < curves.length(); i++) {
            if (curves.charAt(i) == '(') {
                stack.push('(');
            } else if (curves.charAt(i) == ')') {
                stack.pop();
                if (curves.charAt(i - 1) == '(') {
                    counter += stack.size();
                } else {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}