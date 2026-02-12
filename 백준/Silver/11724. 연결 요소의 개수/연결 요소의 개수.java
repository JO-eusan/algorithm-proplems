import java.util.*;
import java.io.*;

public class Main {

    static int[][] matrix;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 간선으로 연결된 정점을 표시하는 배열을 만든다.
        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        // 1. 정점들을 방문하며 연결 리스트를 확인한다.
        int count = 0;
        for(int i=1; i<=N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        // 3. 결과를 출력한다.
        System.out.println(count);
    }

    public static void dfs(int start) {
        int[] linkedpoint = matrix[start];

        for(int i=1; i<=N; i++) {
            if (linkedpoint[i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}