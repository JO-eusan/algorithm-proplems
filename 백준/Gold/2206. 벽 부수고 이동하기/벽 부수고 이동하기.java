
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for(int i=0; i<N; i++) {
            String tmp = br.readLine();

            for(int j=0; j<M; j++) {
                board[i][j] = tmp.charAt(j) - '0';
            }
        }

        System.out.println(bfs(N, M, board));
    }

    private static int bfs(int N, int M, int[][] board) {
        int[][][] dist = new int[N][M][2]; // 0: 이전에 벽 부스지 않음, 1: 벽 부슴
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j][0] = Integer.MAX_VALUE;
                dist[i][j][1] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                
                int distance = dist[now[0]][now[1]][now[2]] + 1;

                if (board[nx][ny] == 0 && distance < dist[nx][ny][now[2]]) {
                    dist[nx][ny][now[2]] = distance;
                    q.offer(new int[] {nx, ny, now[2]});
                } else if (board[nx][ny] == 1 && now[2] == 0 && distance < dist[nx][ny][1]) {
                    dist[nx][ny][1] = distance;
                    q.offer(new int[] {nx, ny, 1});
                }
            }
        }

        int minValue = Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]);
        return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }
}