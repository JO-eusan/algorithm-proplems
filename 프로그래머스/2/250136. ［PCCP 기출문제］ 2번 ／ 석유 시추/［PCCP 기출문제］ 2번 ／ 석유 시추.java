import java.util.*;

class Solution {
    
    /*
     * BFS로 영역별 덩어리 크기 측정
     * 행(m) 길이만큼 순회하면서 Set으로 덩어리 번호 수집 후 크기 최대
    */
    
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        Map<Integer, Integer> oil_area = new HashMap<>();
        int[][] area = new int[n][m];
        int area_idx = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 1 && area[i][j] == 0) {
                    int value = bfs(i, j, land, area, area_idx);
                    oil_area.put(area_idx, value);
                    area_idx++;
                }
            }
        }
        
        int answer = 0;
        
        for(int j=0; j<m; j++) {
            Set<Integer> a = new HashSet<>();
            int sum = 0;
            
            for(int i=0; i<n; i++) {
                if(area[i][j] != 0 && !a.contains(area[i][j])) {
                    sum += oil_area.get(area[i][j]);
                    a.add(area[i][j]);
                }
            }
            
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
    
    private int bfs(int startX, int startY, int[][] land, int[][] area, int area_idx) {
        int n = land.length;
        int m = land[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY});
        area[startX][startY] = area_idx;
        int width = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if(land[nx][ny] == 1 && area[nx][ny] == 0) {
                    q.offer(new int[] {nx, ny});
                    area[nx][ny] = area_idx;
                    width++;
                }
            }
        }
        return width;
    }
}