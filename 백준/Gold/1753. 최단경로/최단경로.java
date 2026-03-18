
import java.io.*;
import java.util.*;

public class Main {

    static int V, E, K;
    static List<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        // 1. 그래프 초기화
        graph = new ArrayList[V + 1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 간선 정보 입력
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
        }

        // 3. 거리 배열 초기화
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 4. 다익스트라 실행
        dijkstra();

        // 5. 결과 출력
        for(int i=1; i<=V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        dist[K] = 0;
        pq.offer(new int[] {K, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int now = curr[0];
            int cost = curr[1];

            if (dist[now] < cost) {
                continue;
            }

            for(int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = next[1];

                int newCost = cost + nextCost;
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[] {nextNode, newCost});
                }
            }
        }
    }
}