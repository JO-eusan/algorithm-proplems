import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        int MAX = 100000;
        int[] dist = new int[MAX + 1];
        boolean[] visited = new boolean[MAX + 1];

        Queue<Integer> queue = new LinkedList<>();
        /* 현재 위치 등록 */
        queue.add(N); 
        visited[N] = true;
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            
            if (x == K) {
                System.out.println(dist[x]);
                return;
            }

            int[] candidates = {x + 1, x - 1, x * 2};
            for(int candidate : candidates) {
                if (candidate < 0 || candidate > MAX) {
                    continue;
                }
                if (visited[candidate]) {
                    continue;
                }

                visited[candidate] = true;
                dist[candidate] = dist[x] + 1;
                queue.add(candidate);
            }
        }
    }
}