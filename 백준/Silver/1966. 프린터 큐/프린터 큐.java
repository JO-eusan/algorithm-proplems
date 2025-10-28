import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] tokens = br.readLine().split(" ");
            int N = Integer.parseInt(tokens[0]);
            int target = Integer.parseInt(tokens[1]);

            String[] numbers = br.readLine().split(" ");
            Queue<Integer> scores = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                scores.add(Integer.parseInt(numbers[i]));
            }

            int count = 0;
            while (!scores.isEmpty()) {
                int firstPoint = scores.poll();

                if (target == 0 && isMaxScore(firstPoint, scores)) {
                    break;
                }
                if (!isMaxScore(firstPoint, scores)) {
                    scores.add(firstPoint);
                } else {
                    count++;        
                }

                target--;
                if (target == -1) {
                    target = scores.size() - 1;
                }
            }
            System.out.println(count + 1);
        }
    }

    private static boolean isMaxScore(int target, Queue<Integer> scores) {
        for(int score : scores) {
            if (target < score) {
                return false;
            }
        }
        return true;
    }
}