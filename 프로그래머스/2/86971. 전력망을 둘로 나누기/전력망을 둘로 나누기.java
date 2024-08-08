import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 인접 행렬 생성
        int[][] graph = new int[n+1][n+1];
    
        for(int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        // 하나의 전선을 끊으면서 탐색
        for(int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            
            /* 연결 끊기 */
            graph[node1][node2] = 0;
            graph[node2][node1] = 0;
            
            int subtreeSize = dfs(graph, new boolean[n+1], node1, n);
            int diff = Math.abs((n-subtreeSize) - subtreeSize);
            answer = Math.min(answer, diff); // 최소값 선택
            
            /* 연결 복구 */
            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }
        
        
        return answer;
    }
    
    public int dfs(int[][] graph, boolean[] visited, int node, int n) {
        visited[node] = true; // 시작 노드
        int count = 1;
        
        /* search */
        for(int i=1; i<=n; i++) { 
            // 시작 노드와 연결 되어 있고 방문하지 않은 곳이라면 count 
            if(graph[node][i] == 1 && !visited[i]) {
                count += dfs(graph, visited, i, n); 
            }
        }
        
        return count;
        
        
    }
}