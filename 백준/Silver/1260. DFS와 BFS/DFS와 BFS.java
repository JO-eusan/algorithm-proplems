import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static boolean[][] matrix;

    private static void dfs(int v) {
        System.out.print(v + " ");
        visited[v] = true;

        for(int i=1; i<matrix.length; i++) {
            if (matrix[v][i] && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.offer(v);

        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");

            for(int i=1; i<matrix.length; i++) {
                if (matrix[vertex][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 간선으로 연결된 인점 행렬을 만든다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        matrix = new boolean[N + 1][N + 1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            matrix[v1][v2] = true;
            matrix[v2][v1] = true;
        }

        // 2. DFS 탐색을 호출한다.
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // 3. BFS 탐색을 호출한다.
        visited = new boolean[N + 1];
        bfs(V);
    }
}