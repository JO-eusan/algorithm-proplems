
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방향을 뒤집어서 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[B].add(A);  // B 해킹 → A 해킹 가능
        }

        int max = 0;
        int[] result = new int[N + 1];

        // 모든 정점에서 BFS
        for (int i = 1; i <= N; i++) {
            result[i] = bfs(i);
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}