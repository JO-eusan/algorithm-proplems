
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N, M, X;
    static List<int[]>[] graph;
    static List<int[]>[] reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] {v, w});
            reverseGraph[v].add(new int[] {u, w});
        }

        int[] distFromX = dijkstra(graph, X);
        int[] distToX = dijkstra(reverseGraph, X);

        int answer = 0;
        for(int i=1; i<=N; i++) {
            answer = Math.max(answer, distFromX[i] + distToX[i]);
        }
        System.out.println(answer);
    }

    public static int[] dijkstra(List<int[]>[] graph, int start) {
        int[] dist = new int[N+1];
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