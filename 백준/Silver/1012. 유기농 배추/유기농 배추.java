import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int M, N;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int i=0; i<4; i++) {
            int r = row + dx[i];
            int c = col + dy[i];

            if ((0 <= r && r < N) && (0 <= c && c < M) && arr[r][c] == 1 && !visited[r][c]) {
                dfs(r, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            // 1. 배추가 심어져 있는 위치와 방문 여부를 표시할 수 있는 배열을 만든다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];

            for(int k=0; k<K; k++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                arr[row][col] = 1;
            }

            // 2. 각 배추의 위치를 확인하면서 같이 속하는 영역을 방문했다고 표시한다.
            int neededBug = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        neededBug++;
                    }
                }
            }

            bw.write(String.valueOf(neededBug) + "\n");
        }

        bw.flush();
        bw.close();
    }
}