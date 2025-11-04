import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            answer.add(Integer.parseInt(br.readLine()));
        }

        int now = 1;
        boolean possible = true;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int number : answer) {
            // number까지 push
            while (now <= number) {
                stack.push(now++);
                sb.append("+\n");
            }

            // 스택 top이 number와 같아야 pop 가능
            if (stack.peek() == number) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 만들 수 없는 수열
                possible = false;
                break;
            }
        }

        if (possible) System.out.print(sb);
        else System.out.println("NO");
    }
}