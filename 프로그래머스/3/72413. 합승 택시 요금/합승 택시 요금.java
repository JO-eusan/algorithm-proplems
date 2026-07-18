import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] f : fares) {
            int u = f[0];
            int v = f[1];
            int c = f[2];
            
            graph[u].add(new int[] {v, c});
            graph[v].add(new int[] {u, c});
        }
        
        int[] dist_s = dikjstra(graph, s); // start: s
        int[] dist_a = dikjstra(graph, a); // start: a
        int[] dist_b = dikjstra(graph, b); // start: b
        
        int separation = dist_s[a] + dist_s[b];
        int together = Integer.MAX_VALUE;
        
        for(int m=1; m<=n; m++) {
            together = Math.min(together, dist_s[m] + dist_a[m] + dist_b[m]);
        }
        
        return Math.min(separation, together);
    }
    
    private int[] dikjstra(List<int[]>[] graph, int start) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            if(dist[node] < cost) {
                continue;
            }
            
            for(int[] next : graph[node]) {
                int nc = dist[node] + next[1];
                
                if(nc < dist[next[0]]) {
                    dist[next[0]] = nc;
                    pq.offer(new int[] {next[0], nc});
                }
            }
        }
        
        return dist;
    }
}