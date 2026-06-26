import java.util.*;

class Solution {
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 테두리 그리기
        int[][] board = new int[102][102];
        
        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int i=y1; i<=y2; i++) {
                for(int j=x1; j<=x2; j++) {
                    if(i==y1 || i==y2 || j==x1 || j==x2) {
                        if(board[i][j] != 2) { // 이미 다른 사각형의 내부가 아닌 경우만 표시
                            board[i][j] = 1;
                        }
                    } else { // 내부
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        // bfs로 가장 먼저 item 위치 도달하는 거리 구하기
        int distance = bfs(board, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return distance / 2;
    }
    
    private int bfs(int[][] board, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[board.length][board.length];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {characterX, characterY, 0});
        visited[characterY][characterX] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];
            
            if(x == itemX && y == itemY) {
                return d;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
                    continue;
                }
                
                if(!visited[ny][nx] && board[ny][nx] == 1) {
                    q.offer(new int[] {nx, ny, d+1});
                    visited[ny][nx] = true;
                }
            }
        }
        return -1;
    }
}