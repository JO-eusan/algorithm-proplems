import java.util.*;

class Solution {
    
    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>> robots = new ArrayList<>();
        
        int maxTime = 0;
        
        for(int[] route : routes) {
            // 로봇별 이동 경로 생성
            List<int[]> path = new ArrayList<>();
            
            // 첫 위치
            int[] cur = points[route[0]-1];
            path.add(new int[] {cur[0], cur[1]});
            
            for(int i=1; i<route.length; i++) {
		            // 다음 목적지
                int[] next = points[route[i]-1];
                
                // r축 방향으로 먼저 이동
                while(cur[0] != next[0]) {
                    if(cur[0] < next[0]) { // (+)
                        cur = new int[] {cur[0]+1, cur[1]};
                    } else { // (-)
                        cur = new int[] {cur[0]-1, cur[1]};
                    }
                    path.add(new int[] {cur[0], cur[1]});
                }
                
                // c축 방향으로 이동해 도착지 가기
                while(cur[1] != next[1]) {
                    if(cur[1] < next[1]) { // (+)
                        cur = new int[] {cur[0], cur[1]+1};
                    } else { // (-)
                        cur = new int[] {cur[0], cur[1]-1};
                    }
                    path.add(new int[] {cur[0], cur[1]});
                }
            }
            
            maxTime = Math.max(maxTime, path.size());
            robots.add(path);
        }
        
        // 시간마다 로봇의 개수가 2이상인지 확인해 충돌 검사
        int answer = 0;
        
        for(int t=0;t<maxTime;t++){
            int[][] count = new int[101][101];
            for(List<int[]> robot : robots){

                if(t < robot.size()){
                    int[] pos = robot.get(t);
                    count[pos[0]][pos[1]]++;
                }
            }

            for(int i=1;i<=100;i++){
                for(int j=1;j<=100;j++){
                    if(count[i][j] >= 2)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}