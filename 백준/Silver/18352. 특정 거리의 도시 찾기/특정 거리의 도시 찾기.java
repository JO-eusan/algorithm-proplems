
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N, M, K, X;
    static List<Integer>[] roads;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        roads = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) {
            roads[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            roads[u].add(v);
        }

        visited = new boolean[N + 1];
        dist = new int[N + 1];

        bfs(X);

        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if (dist[i] == K) {
                result.add(i);
            }
        }

        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            for(int r : result) {
                System.out.println(r);
            }
        }
    }

    public static void bfs(int X) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        visited[X] = true;
        dist[X] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for(int next : roads[now]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                }
            }
        }
    }
}