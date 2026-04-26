
import java.io.*;
import java.util.*;

public class Main {

    static List<int[]>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(start, N);
        System.out.println(dist[end]);
    }

    private static int[] dijkstra(int start, int N) {
        int[] dist = new int[N+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];

            if (cost < dist[node]) {
                continue;
            }

            for(int[] next : graph[node]) {
                int nextNode = next[0];
                int nextCost = next[1];

                int newCost = cost == 0 ? nextCost : Math.min(cost, nextCost);
                if (dist[nextNode] < newCost) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[] {nextNode, newCost});
                }
            }
        }

        return dist;
    }
}