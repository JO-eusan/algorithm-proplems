import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i < N; i++) {
            Stack<Character> stack = new Stack<>();

            String word = br.readLine();
            for(int j=0; j < word.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(word.charAt(j));
                } else if (stack.peek() == word.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(word.charAt(j));
                }
            }
            
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}