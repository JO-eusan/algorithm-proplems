import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        int[] start = new int[2];
        int[] end = new int[2];
        
        int[][] game = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char c = board[i].charAt(j);
                
                if(c == 'D') {
                    game[i][j] = 1;
                } else {
                    game[i][j] = 0;
                }
                
                if(c == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if(c == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        return bfs(n, m, game, start, end);
    }
    
    private int bfs(int n, int m, int[][] board, int[] start, int[] end) {
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if(now[0] == end[0] && now[1] == end[1]) {
                return now[2];
            }
            
            for(int i=0; i<4; i++) {
                int nx = now[0];
                int ny = now[1];
                
                while((nx >= 0 && nx < n && ny >= 0 && ny < m) && board[nx][ny] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if(now[0] == nx && now[1] == ny) {
                    continue;
                }
                if(visited[nx][ny]) {
                    continue;
                }
                
                q.offer(new int[] {nx, ny, now[2] + 1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}