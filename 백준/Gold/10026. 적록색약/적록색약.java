
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1 ,0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        // 1. board를 채운다. (R = 0, G = 1, B = 2)
        for(int i=0; i<N; i++) {
            String tmp = br.readLine();

            for(int j=0; j<N; j++) {
                switch (tmp.charAt(j)) {
                    case 'R':
                        board[i][j] = 0;
                        break;
                    case 'G':
                        board[i][j] = 1;
                        break;
                    case 'B':
                        board[i][j] = 2;
                        break;
                }
            }
        }

        // 2. 적록색약이 아닌 사람이 봤을 때의 구역의 개수를 구한다.
        int count_RGB = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    dfs_RGB(i, j);
                    count_RGB++;
                }
            }
        }

        // 3. 적록 색약인 사람이 봤을 때의 구역의 개수를 구한다.
        int count_RB = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    dfs_RB(i, j);
                    count_RB++;
                }
            }
        }

        // 4. 결과를 출력한다.
        System.out.println(count_RGB + " " + count_RB);
    }

    public static void dfs_RGB(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if ((0 <= newX && newX < N) && (0 <= newY && newY < N) && !visited[newX][newY]) {
                if (board[x][y] == board[newX][newY]) {
                    dfs_RGB(newX, newY);   
                }
            }
        }
    }

    public static void dfs_RB(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if ((0 <= newX && newX < N) && (0 <= newY && newY < N) && !visited[newX][newY]) {
                if (board[x][y] == board[newX][newY]
                     || (board[x][y] == 0 && board[newX][newY] == 1)
                     || (board[x][y] == 1 && board[newX][newY] == 0)) {
                    dfs_RB(newX, newY);   
                }
            }
        }
    }
}