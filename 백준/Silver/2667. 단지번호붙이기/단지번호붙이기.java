import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int N;

    public static int bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int[][] candidates = {{point[0] - 1, point[1]}, {point[0], point[1] - 1}, {point[0] + 1, point[1]}, {point[0], point[1] + 1}};
            
            for(int i = 0; i < 4; i++) {
                int row = candidates[i][0];
                int col = candidates[i][1];
                
                if ((0 <= row && row < N) && (0 <= col && col < N) 
                    && arr[row][col] == 1 && !visited[row][col]) {
                    
                    q.offer(new int[]{row, col});
                    visited[row][col] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 집의 여부를 판단하는 배열과 방문 여부를 판단하는 배열을 초기화한다.
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            String nums = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = nums.charAt(j) - '0';
            }
        }

        // 2. 집을 순회하면서 새로 접근한 집일 때 영역을 탐지한다.
        int countryCount = 0;
        List<Integer> homeCounters = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    countryCount++;
                    int homeCount = bfs(new int[]{i, j});
                    homeCounters.add(homeCount);
                }
            }
        }

        // 3. 총 단지수를 출력하고 오름차순으로 정렬한 집의 수를 출력한다.
        Collections.sort(homeCounters);
        
        System.out.println(countryCount);
        for(int h : homeCounters) {
            System.out.println(h);
        }
    }
}