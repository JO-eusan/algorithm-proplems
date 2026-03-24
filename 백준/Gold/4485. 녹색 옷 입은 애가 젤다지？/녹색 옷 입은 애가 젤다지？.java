
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int game = 1;

        while (N != 0) {
            int[][] board = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("Problem " + game + ": " + dijkstra(N, board) + "\n");

            N = Integer.parseInt(br.readLine());
            game++;
        }

        bw.flush();
        bw.close();
    }

    public static int dijkstra(int N, int[][] board) {
        int[][] dist = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        dist[0][0] = board[0][0];
        q.offer(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cost = dist[now[0]][now[1]];

            for(int i=0; i<4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || N <= x || y < 0 || N <= y) {
                    continue;   
                }

                int newCost = cost + board[x][y];
                if (newCost < dist[x][y]) {
                    dist[x][y] = newCost;
                    q.offer(new int[] {x, y});
                }
            }
        }

        return dist[N-1][N-1];
    }
}