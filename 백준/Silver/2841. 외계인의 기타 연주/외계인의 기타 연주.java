import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        HashMap<Integer, Stack<Integer>> lines = new HashMap<>();
        for(int i = 1; i <= 6; i++) {
            lines.put(i, new Stack<>());
        }

        int result = 0;
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());

            Stack<Integer> numbers = lines.get(line);
            if (numbers.isEmpty() || numbers.peek() < flat) {
                result++;
                numbers.add(flat);
            } else if (numbers.peek() > flat) {
                while (!numbers.isEmpty() && numbers.peek() > flat) {
                    result++;
                    numbers.pop();
                }

                if (numbers.isEmpty() || numbers.peek() < flat) {
                    result++;
                    numbers.add(flat);
                }
            }
        }
        System.out.println(result);
    }
}