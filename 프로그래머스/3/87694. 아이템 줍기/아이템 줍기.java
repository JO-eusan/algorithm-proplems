import java.util.*;

class Solution {
    // 이동 방향 (상, 하, 좌, 우)
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표 확대 (2배)
        int[][] map = new int[102][102];
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            // 직사각형 테두리 부분을 1로 표시
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] == 0) {
                            map[i][j] = 1;
                        }
                    } else {
                        map[i][j] = -1; // 내부는 -1로 표시
                    }
                }
            }
        }
        
        // BFS 탐색
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        
        queue.offer(new int[]{characterX * 2, characterY * 2, 0}); // 시작점
        visited[characterX * 2][characterY * 2] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 아이템 위치에 도달했을 경우
            if (x == itemX * 2 && y == itemY * 2) {
                return distance / 2;
            }
            
            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102 && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        return -1; // 경로를 찾지 못한 경우 (사실상 발생하지 않음)
    }
}