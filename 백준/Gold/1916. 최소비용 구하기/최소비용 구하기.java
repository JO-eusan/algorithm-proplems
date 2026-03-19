
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
        }

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        System.out.println(dist[end]);
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int nowVertex = now[0];
            int nowWeight = now[1];

            if (dist[nowVertex] < nowWeight) {
                continue;
            }

            for(int[] next : graph[nowVertex]) {
                int nextVertex = next[0];
                int nextWeight = next[1];

                int newCost = nowWeight + nextWeight;
                if (newCost < dist[nextVertex]) {
                    dist[nextVertex] = newCost;
                    pq.offer(new int[] {nextVertex, newCost});
                }
            }
        }
    }
}