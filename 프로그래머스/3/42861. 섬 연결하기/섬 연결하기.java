import java.util.*;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for(int i=0; i<costs.length; i++) {
            pq.offer(new int[] {costs[i][0], costs[i][1], costs[i][2]});
        }
        
        parent = new int[n];
        
        // Union 초기화
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int total = 0;
        int edgeCount = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int a = now[0];
            int b = now[1];
            int cost = now[2];
            
            if(find(a) == find(b)) continue;
            
            union(a, b);
            total += cost;
            edgeCount++;
            
            if(edgeCount == n-1) break;
        }
        
        return total;
    }
    
    private int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        
        int root = find(parent[x]);
        
        parent[x] = root;
        return root;
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return;
        
        parent[rootB] = rootA;
    }
}