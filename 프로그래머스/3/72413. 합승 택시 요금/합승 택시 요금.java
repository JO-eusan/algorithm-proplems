import java.util.*;

class Solution {
    
    private List<int[]>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] f : fares) {
            graph[f[0]].add(new int[] {f[1], f[2]});
            graph[f[1]].add(new int[] {f[0], f[2]});
        }
        
        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);
        
        // 'S -> X' + 'X -> A' + 'X -> B'
        // 'S -> A' + 'S -> B'
        int separation = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++) {
            int total = distS[i] + distA[i] + distB[i];
            separation = Math.min(separation, total);
        }
        return Math.min(separation, distS[a] + distS[b]);
    }
    
    private int[] dijkstra(int start, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            if(dist[node] < cost) continue;
            
            for(int[] next : graph[node]) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                int newCost = dist[node] + nextCost;
                if(newCost < dist[nextNode]) {
                    pq.offer(new int[] {nextNode, newCost});
                    dist[nextNode] = newCost;
                }
            }
        }
        return dist;
    }
}