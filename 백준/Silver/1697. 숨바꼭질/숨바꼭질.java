import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int duration = bfs(N, K);
        System.out.println(duration);
    }

    public static int bfs(int N, int K) {
        boolean[] visited = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();

        q.offer(N);
        visited[N] = true;

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int X = q.poll();

                if (X == K) {
                    return time;
                }

                int[] nexts = {X + 1, X - 1, 2 * X};
                for (int next : nexts) {
                    if (0 <= next && next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}