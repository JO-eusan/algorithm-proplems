
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static boolean[] selected;
    static int minDistance = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new int[] {i, j});
                } else if (value == 2) {
                    chickens.add(new int[] {i, j});
                }
            }
        }

        selected = new boolean[chickens.size()];
        dfs(0, 0);

        System.out.println(minDistance);
    }

    private static void dfs(int start, int cnt) {
        if (cnt == M) {
            // 치킨 거리 구하기
            int distance = calDistance();
            minDistance = Math.min(distance, minDistance);
            return;
        }

        for(int i=start; i<chickens.size(); i++) {
            selected[i] = true;
            dfs(i + 1, cnt + 1);
            selected[i] = false;
        }
    }

    private static int calDistance() {
        int sum = 0;

        for(int[] house : houses) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int[] chicken = chickens.get(i);
                    int d = Math.abs(house[0] - chicken[0]) 
                        + Math.abs(house[1] - chicken[1]);
                    min = Math.min(min, d);
                }
            }
            sum += min;
        }
        
        return sum;
    }
}