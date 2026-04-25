
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken()); // 무게
            jewels[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        int[] bags = new int[K];
        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 1. 보석 무게 기준 정렬
        Arrays.sort(jewels, (a, b) -> a[0] - b[0]);

        // 2. 가방 오름차순 정렬
        Arrays.sort(bags);

        // 3. 가치 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int idx = 0;

        // 4. 가방 순회
        for(int i = 0; i < K; i++) {

            // 현재 가방에 넣을 수 있는 보석 전부 넣기
            while (idx < N && jewels[idx][0] <= bags[i]) {
                pq.offer(jewels[idx][1]);
                idx++;
            }

            // 가장 비싼 보석 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}