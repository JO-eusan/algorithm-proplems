
import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = {1, -1, 0, 0, 0, 0};
    private static final int[] dy = {0, 0, 1, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};

    private static int[][][] board;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        board = new int[N][M][H];
        visited = new boolean[N][M][H];

        List<int[]> tomatoes = new ArrayList<>();

        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());

                for(int m=0; m<M; m++) {
                    int value = Integer.parseInt(st.nextToken());
                    board[n][m][h] = value;
                    visited[n][m][h] = (value != 0);

                    if (value == 1) {
                        tomatoes.add(new int[] {n, m, h});
                    }
                }
            }
        }
        
        int counter = bfs(tomatoes, N, M, H);

        if (isCompleteTomatoes(N, M, H)) {
            System.out.println(counter);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs(List<int[]> starts, int N, int M, int H) {
        Queue<int[]> q = new LinkedList<>(starts);

        int counter = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                int[] current = q.poll();

                for(int j=0; j<6; j++) {
                    int newN = current[0] + dx[j];
                    int newM = current[1] + dy[j];
                    int newH = current[2] + dz[j];

                    if (newN < 0 || newN >= N || newM < 0 || newM >= M || newH < 0 || newH >= H) {
                        continue;
                    }

                    if (!visited[newN][newM][newH]) {
                        q.offer(new int[] {newN, newM, newH});
                        visited[newN][newM][newH] = true;
                    }
                }
            }
            counter++;
        }

        return counter;
    }

    private static boolean isCompleteTomatoes(int N, int M, int H) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<H; k++) {
                    if (!visited[i][j][k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}