import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] dist = new int[n][n][4];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});
        q.offer(new int[] {0, 0, 2});
        dist[0][0][0] = 0;
        dist[0][0][2] = 0;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int dir = now[2]; 
            
            for(int ndir=0; ndir<4; ndir++) {
                int nx = x + dx[ndir];
                int ny = y + dy[ndir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                
                int cost = dist[x][y][dir] + 100;
                
                if(dir != ndir) {
                    cost += 500;
                }
                
                if(cost < dist[nx][ny][ndir]) {
                    dist[nx][ny][ndir] = cost;
                    q.offer(new int[] {nx, ny, ndir});
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<4; i++) {
            answer = Math.min(answer, dist[n-1][n-1][i]);
        }
        return answer;
    }
}