
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        result = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            bfs(i);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for(int i=0; i<N; i++) {
                if (board[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    result[start][i] = 1;
                    q.offer(i);
                }
            }
        }
    }
}