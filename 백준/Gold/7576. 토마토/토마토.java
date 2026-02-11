import java.util.*;
import java.io.*;

public class Main {

    static int M, N;
    static int[][] tomatos;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 토마토의 상태를 저장하면서 초기 토마토 위치를 기록한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatos = new int[N][M];

        List<int[]> startPoints = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                tomatos[i][j] = num;

                if (num == 1) {
                    startPoints.add(new int[] {i, j});
                }
            }
        }

        // 2. BFS로 보면서 모든 토마토가 소모될 때까지 날짜를 계산한다.
        int duration = bfs(startPoints);

        // 3. 토마토의 상태에 따라 출력한다.
        int status = checkStatus(duration);
        System.out.println(status);
    }

    public static int bfs(List<int[]> startPoints) {
        int duration = 0;
        int size = startPoints.size();
        Queue<int[]> q = new LinkedList<>(startPoints);

        while (!q.isEmpty()) {
            if (size == 0) {
                duration++;
                size = q.size();
            }

            int[] point = q.poll();

            for(int i=0; i<4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];

                if ((0 <= x && x < N) && (0 <= y && y < M) && tomatos[x][y] == 0) {
                    q.offer(new int[] {x, y});
                    tomatos[x][y] = 1;
                }
            }
            size--;
        }
        return duration;
    }

    public static int checkStatus(int duration) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (tomatos[i][j] == 0) {
                    return -1;
                }
            }
        }
        return duration;
    }
}