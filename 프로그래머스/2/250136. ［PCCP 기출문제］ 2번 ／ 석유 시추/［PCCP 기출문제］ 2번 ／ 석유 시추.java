import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] area = new int[n][m];
        
        int idx = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    int total = bfs(idx, i, j, area, visited, land);
                    map.put(idx, total);
                    idx++;
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<m; i++) {
            HashSet<Integer> set = new HashSet<>();
            int total = 0;
            
            for(int j=0; j<n; j++) {
                int now = area[j][i];
                if(now != 0 && !set.contains(now)) {
                    set.add(now);
                    total += map.get(now);
                }
            }
            
            if (total > answer) {
                answer = total;
            }
        }
        
        return answer;
    }
    
    private int bfs(int idx, int x, int y, int[][] area, boolean[][] visited, int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        area[x][y] = idx;
        visited[x][y] = true;
        
        int size = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if(!visited[nx][ny] && land[nx][ny] == 1) {
                    q.offer(new int[] {nx, ny});
                    area[nx][ny] = idx;
                    visited[nx][ny] = true;
                    size++;
                }
            } 
        }
        return size;
    }
}