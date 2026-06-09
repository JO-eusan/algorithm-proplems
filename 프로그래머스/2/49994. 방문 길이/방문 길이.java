import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        
        boolean[][][][] visited = new boolean[11][11][11][11];
        
        for(int i=0; i<dirs.length(); i++) {
            char c = dirs.charAt(i);
            int nextX = x;
            int nextY = y;
            
            if(c == 'U') {
                nextY++;
            } else if(c == 'D') {
                nextY--;
            } else if(c == 'R') {
                nextX++;
            } else if(c == 'L') {
                nextX--;
            }
            
            if(nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }
            if(visited[x+5][y+5][nextX+5][nextY+5] || visited[nextX+5][nextY+5][x+5][y+5]) {
                x = nextX;
                y = nextY;
                continue;
            }
            
            visited[x+5][y+5][nextX+5][nextY+5] = true;
            visited[nextX+5][nextY+5][x+5][y+5] = true;
            
            answer++;
            x = nextX;
            y = nextY;
        }
        
        return answer;
    }
}