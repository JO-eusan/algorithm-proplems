import java.util.*;

class Solution {
    
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] board) {
        return dijkstra(board, board.length);
    }
    
    private int dijkstra(int[][] board, int N) {
        Queue<int[]> q = new LinkedList<>();
        
        // 방향을 위해 한 칸 이동한 2지점에서 시작 (x, y, dir)
        q.offer(new int[] {0, 0, 0});
        q.offer(new int[] {0, 0, 1});
        
        int[][][] dist = new int[N][N][2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dist[i][j][0] = Integer.MAX_VALUE;
                dist[i][j][1] = Integer.MAX_VALUE;
            }
        }
        
        dist[0][0][0] = dist[0][0][1] = 0;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nd = (i % 2);
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                if(board[nx][ny] == 0) {
                    int cost = dist[x][y][d] + 100;
                    if(d != nd) cost += 500;
                    
                    if(cost < dist[nx][ny][nd]) {
                        q.offer(new int[] {nx, ny, nd});
                        dist[nx][ny][nd] = cost;
                    }
                }
            }
        }
        
        return Math.min(dist[N-1][N-1][0], dist[N-1][N-1][1]);
    }
}