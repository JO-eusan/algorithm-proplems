import java.util.*;

class Solution {
    
    boolean[][] lines;
    
    public int bfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        
        int count = 1;
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            for(int i=1; i<=n; i++) {
                if(lines[num][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return Math.abs(count - (n - count));
    }
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        lines = new boolean[n + 1][n + 1];
        
        // 1. 연결된 전선을 인접 행렬에 저장합니다.
        for(int i=0; i<wires.length; i++) {
            lines[wires[i][0]][wires[i][1]] = true;
            lines[wires[i][1]][wires[i][0]] = true;
        }
        
        // 2. 선을 하나씩 끊어보면서 순회합니다.
        for(int i=0; i<wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            
            lines[x][y] = false;
            lines[y][x] = false;
            
            answer = Math.min(answer, bfs(n, x));
            
            lines[x][y] = true;
            lines[y][x] = true;
        }
        
        return answer;
    }
}