import java.util.*;

class Solution {
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int color = picture[i][j];
                
                if(!visited[i][j] && color != 0) {
                    int area = bfs(i, j, color, m, n, picture, visited);
                    
                    numberOfArea++;
                    
                    if(area > maxSizeOfOneArea) {
                        maxSizeOfOneArea = area;
                    }
                }
            }
        }
        
        return new int[] {numberOfArea, maxSizeOfOneArea};
    }
    
    private int bfs(int startX, int startY, int target, int m, int n, int[][] picture, boolean[][] visited) {
        int area = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY});
        visited[startX][startY] = true;
        area++;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            for(int i=0; i<4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                
                if(x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                
                if(!visited[x][y] && picture[x][y] == target) {
                    q.offer(new int[] {x, y});
                    visited[x][y] = true;
                    area++;
                }
            }
        }
        
        return area;
    }
}