import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int[] start = new int[2];
        int[] lebber = new int[2];
        int[] end = new int[2];
        
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j] = maps[i].charAt(j);
                
                if(board[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if(board[i][j] == 'L') {
                    lebber[0] = i;
                    lebber[1] = j;
                } else if(board[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int road1 = bfs(n, m, board, start, lebber);
        int road2 = bfs(n, m, board, lebber, end);
        
        if(road1 == -1 || road2 == -1) {
            return -1;
        }
        return road1 + road2;
    }
    
    private int bfs(int n, int m, char[][] board, int[] start, int[] end) {
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        
        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 0;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if(visited[nx][ny] || board[nx][ny] == 'X') {
                    continue;
                }
                
                q.offer(new int[] {nx, ny});
                visited[nx][ny] = true;
                dist[nx][ny] = dist[now[0]][now[1]] + 1;
            }
        }
        
        return dist[end[0]][end[1]] == Integer.MAX_VALUE ? -1 : dist[end[0]][end[1]];
    }
}