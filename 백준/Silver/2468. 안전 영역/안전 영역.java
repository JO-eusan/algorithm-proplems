import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        
        // 1. 지역의 높이 정보를 입력 받으면서 상한선을 찾는다.
        int maxValue = 0;
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int inputValue = Integer.parseInt(st.nextToken());
                board[i][j] = inputValue;

                if (inputValue > maxValue) {
                    maxValue = inputValue;
                }
            }
        }

        // 2. 비의 양을 올리면서 안정 영역의 개수를 탐색하여 최대값을 갱신한다.
        int maxSafeCount = 1;

        for(int n=1; n<maxValue; n++) {
            // 2-1. 방문 배열을 초기화한다.
            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (board[i][j] <= n) {
                        visited[i][j] = true;
                    }
                }
            }

            // 2-2. 안정 영역을 방문 처리하면서 개수를 센다.
            int count = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            // 2-3. 최대 안정 영역을 갱신한다.
            if (count > maxSafeCount) {
                maxSafeCount = count;
            }
        }

        // 3. 결과값을 출력한다.
        System.out.println(maxSafeCount);
    }

    public static void dfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] v = q.poll();

            for(int i=0; i<4; i++) {
                int newR = v[0] + dr[i];
                int newC = v[1] + dc[i];

                if ((0 <= newR && newR < N) && (0 <= newC && newC < N) && !visited[newR][newC]) {
                    q.offer(new int[] {newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }
    }
}