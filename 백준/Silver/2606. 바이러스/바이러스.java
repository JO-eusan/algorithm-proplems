import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] matrix;
    static boolean[] visited;
    static int cnt = 0;

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int v = q.poll();

            for(int i=1; i<matrix.length; i++) {
                if (matrix[v][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 1. 네트워크로 연결된 인접 행렬을 만든다.
        matrix = new boolean[N + 1][N + 1];

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            matrix[v1][v2] = true;
            matrix[v2][v1] = true;
        }

        // 2. bfs로 연결된 노드의 개수를 count 한다.
        visited = new boolean[N + 1];
        bfs(1);

        // 3. 탐색이 완료되었을 때 count를 출력한다.
        System.out.println(cnt);
    }
}