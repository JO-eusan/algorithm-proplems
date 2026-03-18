
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] end = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            
            System.out.println(bfs(I, start, end));
        }
    }

    public static int bfs(int I, int[] start, int[] end) {
        int counter = 0;
        boolean[][] visited = new boolean[I][I];
        Queue<int[]> q = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cycleSize = q.size();
            
            for(int i=0; i<cycleSize; i++) {
                int[] now = q.poll();

                if (now[0] == end[0] && now[1] == end[1]) {
                    return counter;
                }

                for(int j=0; j<8; j++) {
                    int newX = now[0] + dx[j];
                    int newY = now[1] + dy[j];

                    if (0 <= newX && newX < I && 0 <= newY && newY < I && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        q.offer(new int[] {newX, newY});
                    }
                }
            }
            counter++;
        }
        return counter;
    }
}