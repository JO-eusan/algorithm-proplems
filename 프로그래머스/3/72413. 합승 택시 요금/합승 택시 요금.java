import java.util.*;

class Solution {
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<fares.length; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            int w = fares[i][2];
            
            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }
        
        int[] distFromS = dijkstra(graph, s);
        int[] distFromA = dijkstra(graph, a);
        int[] distFromB = dijkstra(graph, b);
        
        int separation = distFromS[a] + distFromS[b]; // s - A and s - B
        int together = Integer.MAX_VALUE;
        
        for (int i=1; i<=n; i++) {
            int distance = distFromS[i] + distFromA[i] + distFromB[i];
            
            if (distance < together) {
                together = distance;
            }
        }
        
        return Math.min(together, separation);
    }
    
    private int[] dijkstra(List<int[]>[] graph, int start) {
        int[] dist = new int[graph.length + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            if (dist[node] < cost) {
                continue;
            }
            
            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                int newCost = cost + nextCost;
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[] {nextNode, newCost});
                }
            }
        }
        return dist;
    }
}