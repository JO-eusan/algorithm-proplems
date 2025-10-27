import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int N, M;
    private static int[][] board;
    private static boolean[][] visited; // 이미 방문한 칸을 다시 방문하지 않도록 체크
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        board = new int[N][M];
        visited = new boolean[N][M];

        /* 미로 정보 입력 */
        for(int i=0; i < N; i++) {
            String numbers = br.readLine();
            for(int j=0; j < M; j++) {
                board[i][j] = numbers.charAt(j) - '0';
            }
        }

        /* bfs로 미로 최단 경로 찾기 */
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> points = new LinkedList<>(); // bfs 구현
        
        /* 시작 지점 경로에 추가 */
        points.add(new int[] {startX, startY}); 
        visited[startX][startY] = true;

        /* 각 칸까지의 거리 저장 */
        int[][] dist = new int[N][M];
        dist[startX][startY] = 1;

        while (!points.isEmpty()) {
            int[] now = points.poll(); // 현재 위치
            int x = now[0];
            int y = now[1];

            for(int i=0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (board[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                points.add(new int[] {nx, ny});
            }
        }
        return dist[N - 1][M - 1];
    }
}