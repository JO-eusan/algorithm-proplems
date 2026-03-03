import java.util.*;
import java.io.*;

public class Main {

    static int MIN_SIZE = 0;
    static int MAX_SIZE = 100_000;
    static int N;
    static int K;

    public static int bfs() {
        int[] durations = new int[MAX_SIZE + 1];
        boolean[] visited = new boolean[MAX_SIZE + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        visited[N] = true;
        
        while (!dq.isEmpty()) {
            int X = dq.pollFirst();

            if (X == K) {
                return durations[X];
            }

            if (validateSize(2 * X) && !visited[2 * X]) {
                dq.offerFirst(2 * X);
                durations[2 * X] = durations[X];
                visited[2 * X] = true;
            }
            if (validateSize(X - 1) && !visited[X - 1]) {
                dq.offerLast(X - 1);
                durations[X - 1] = durations[X] + 1;
                visited[X - 1] = true;
            }
            if (validateSize(X + 1) && !visited[X + 1]) {
                dq.offerLast(X + 1);
                durations[X + 1] = durations[X] + 1;
                visited[X + 1] = true;
            }
        }
        return -1;
    }

    public static boolean validateSize(int X) {
        if (MIN_SIZE <= X && X <= MAX_SIZE) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1. 동생이 있는 위치까지 도달하는 최단 시간을 탐색한다.
        int duration = bfs();

        // 2. 결과를 출력한다.
        System.out.println(duration);
    }
}