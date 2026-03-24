
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++) {
            String num = br.readLine();

            for(int j=0; j<M; j++) {
                board[i][j] = num.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        System.out.println(dist[N-1][M-1]);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if ((0 <= x && x < N) && (0 <= y && y < M)) {
                    int nextCount = dist[now[0]][now[1]];
                    if (board[x][y] == 1) {
                        nextCount++;
                    }

                    if (nextCount < dist[x][y]) {
                        dist[x][y] = nextCount;
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
    }
}