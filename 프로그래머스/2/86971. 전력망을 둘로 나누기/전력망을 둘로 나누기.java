import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        boolean[][] matrix = new boolean[n+1][n+1];
        
        for(int[] w : wires) {
            int u = w[0];
            int v = w[1];
            
            matrix[u][v] = true;
            matrix[v][u] = true;
        }
        
        // wire 하나씩 제거 후 bfs로 최소값 찾기
        int answer = Integer.MAX_VALUE;
        
        for(int[] w : wires) {
            int u = w[0];
            int v = w[1];
            
            matrix[u][v] = false;
            matrix[v][u] = false;
            
            answer = Math.min(answer, Math.abs(n - 2*bfs(matrix)));
            
            matrix[u][v] = true;
            matrix[v][u] = true;
        }
        
        return answer;
    }
    
    private int bfs(boolean[][] matrix) {
        Set<Integer> num = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        num.add(1);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int i=1; i<matrix.length; i++) {
                if(matrix[now][i] && !num.contains(i)) {
                    q.offer(i);
                    num.add(i);
                }
            }
        }
        return num.size();
    }
}