
import java.io.*;
import java.util.*;

public class Main {

    static int N, E;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);
        
        long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        long result = Math.min(path1, path2);

        if (result >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowNode = now[0];
            int nowCost = now[1];

            if (dist[nowNode] < nowCost) {
                continue;
            }

            for(int[] next : graph[nowNode]) {
                int nextNode = next[0];
                int nextCost = next[1];

                int newCost = nowCost + nextCost;
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[] {nextNode, newCost});
                }
            }
        }
        return dist;
    }
}