import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String command = br.readLine();
            process(command);
        }
    }

    public static void process(String command) {
        if (command.contains("push")) {
            int n = Integer.parseInt(command.split(" ")[1]);
            stack.push(n);
        } else if (command.contains("pop")) {
            if (stack.empty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.pop());
            }
        } else if (command.contains("size")) {
            System.out.println(stack.size());
        } else if (command.contains("empty")) {
             if (stack.empty()) {
                System.out.println(1);
             } else {
                System.out.println(0);
             }
        } else {
            if (stack.empty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.peek());
            }
        }
    }
}