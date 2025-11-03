import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int exercise_count = 0;
        int time_count = 0;
        int X = m;
        while (exercise_count != N) {
            if (m + T > M) {
                time_count = -1;
                break;
            }

            if (X + T <= M) { // 운동
                exercise_count++;
                X += T;
            } else {
                X = Math.max(X - R, m);
            }
            time_count++;
        }
        System.out.println(time_count);
    }
}