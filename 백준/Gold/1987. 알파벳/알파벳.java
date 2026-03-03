import java.util.*;
import java.io.*;

public class Main {

    static int R;
    static int C;
    static int maxValue;
    static char[][] alphabets;
    static boolean[] visited = new boolean[26];
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 1. 알파벳 보드판을 만든다.
        alphabets = new char[R][C];
        
        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for(int j=0; j<C; j++) {
                alphabets[i][j] = line.charAt(j);
            }
        }

        // 2. dfs로 최대 깊이만큼 탐색하는 값을 갱신한다.
        visited[alphabets[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        // 3. 최대 깊이를 출력한다.
        System.out.println(maxValue);
    }

    public static void dfs(int r, int c, int depth) {
        maxValue = Math.max(maxValue, depth);

        for(int i=0; i<4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            if (0 <= newR && newR < R && 0 <= newC && newC < C) {
                int idx = alphabets[newR][newC] - 'A';

                if (!visited[idx]) {
                    visited[idx] = true;
                    dfs(newR, newC, depth + 1);
                    visited[idx] = false;
                }
            }
        }
    }
}