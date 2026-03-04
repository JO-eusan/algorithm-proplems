import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int maxSafeCount;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 1. 연구소 정보를 입력받는다.
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 백트래킹으로 벽을 세울 3가지 영역을 찾아서 안전 영역을 갱신한다.
        dfs(0);

        // 3. 결과값을 출력한다.
        System.out.println(maxSafeCount);
    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            // 2-1. 벽을 다 세우면 bfs로 바이러스를 전파시킨다.
            int[][] newBoard = new int[N][M];
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }

            int[][] map = bfs(newBoard);

            // 2-2. 바이러스 전파 후 안전 영역을 count하고 최대값을 갱신시킨다.
            int count = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }

            if (count > maxSafeCount) {
                maxSafeCount = count;
            }

            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(cnt + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int[][] bfs(int[][] boardWithWall) {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (boardWithWall[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] v = q.poll();

            for(int i=0; i<4; i++) {
                int newX = v[0] + dx[i];
                int newY = v[1] + dy[i];

                if ((0 <= newX && newX < N) && (0 <= newY && newY < M) && (boardWithWall[newX][newY] == 0)) {
                    boardWithWall[newX][newY] = 2;
                    q.offer(new int[] {newX, newY});
                }
            }
        }
        return boardWithWall;
    }
}