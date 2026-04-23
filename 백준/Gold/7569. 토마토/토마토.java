
import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = {1, -1, 0, 0, 0, 0};
    private static final int[] dy = {0, 0, 1, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};

    private static int emptySpace = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] board = new int[N][M][H];
        List<int[]> tomatoes = new ArrayList<>();

        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());

                for(int m=0; m<M; m++) {
                    int value = Integer.parseInt(st.nextToken());
                    board[n][m][h] = value;

                    if (value == 1) {
                        tomatoes.add(new int[] {n, m, h});
                    }
                    if (value == 0) {
                        emptySpace++;
                    }
                }
            }
        }
        
        int counter = bfs(tomatoes, board, N, M, H);

        if (emptySpace > 0) {
            System.out.println(-1);
        } else {
            System.out.println(counter);
        }
    }

    private static int bfs(List<int[]> starts, int[][][] board, int N, int M, int H) {
        Queue<int[]> q = new LinkedList<>(starts);

        int counter = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();            
            
            for(int j=0; j<6; j++) {
                int newN = current[0] + dx[j];
                int newM = current[1] + dy[j];
                int newH = current[2] + dz[j];

                if (newN < 0 || newN >= N || newM < 0 || newM >= M || newH < 0 || newH >= H) {
                    continue;
                }

                if (board[newN][newM][newH] == 0) {
                    q.offer(new int[] {newN, newM, newH});
                    board[newN][newM][newH] = board[current[0]][current[1]][current[2]] + 1;
                    
                    emptySpace--;
                    counter = Math.max(counter, board[current[0]][current[1]][current[2]]);
                }
            }
        }

        return counter;
    }
}