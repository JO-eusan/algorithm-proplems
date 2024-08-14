import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int lastCamera = Integer.MIN_VALUE; // 마지막으로 설치된 카메라의 위치
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        for(int[] route : routes) {
            // 현재 차량의 시작 지점이 마지막 카메라 위치보다 크면 새로운 카메라가 필요
            if(lastCamera < route[0]) {
                answer++;
                lastCamera = route[1]; // update
            }
        }
        
        return answer;
    }
}