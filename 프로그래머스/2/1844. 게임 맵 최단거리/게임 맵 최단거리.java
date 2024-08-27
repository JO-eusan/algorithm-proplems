import java.util.*;

class Solution {
    
    /* 이동 방향: (1,0) (-1,0) (0,1) (0,-1) */
    int[] dX = {1, -1, 0, 0};
    int[] dY = {0, 0, 1, -1};
    
    int[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        //maps와 동일한 크기의 방문 표시
        visited = new int[maps.length][maps[0].length]; 
        
        bfs(maps);
        answer = visited[maps.length - 1][maps[0].length - 1];
        
        if(answer == 0) // 도착 불가능
            answer = -1;
        
        return answer;
    }
    
    public void bfs(int[][] maps) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1; // (0,0)에서 시작
        
        /* bfs start */
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); // (0,0)좌표 push
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cX = current[0];
            int cY = current[1];
            
            for(int i=0; i<4; i++) { // 4방향 확인
                int nX = cX + dX[i];
                int nY = cY + dY[i];
                
                //못가는 경우
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;
                
                //이동 가능한 경우
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[cX][cY] + 1; //이동
                    queue.add(new int[]{nX, nY}); //현재 좌표 큐에 추가
                }
            }
        }
    }
}