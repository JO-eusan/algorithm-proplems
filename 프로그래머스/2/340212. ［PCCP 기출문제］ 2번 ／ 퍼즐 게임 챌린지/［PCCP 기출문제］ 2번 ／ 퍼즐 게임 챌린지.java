import java.util.*;

class Solution {
    
    /*
     * n개의 퍼즐은 난이도, 소요시간 존재
     * diff : 현재 퍼즐의 난이도
     * time_cur : 현재 퍼즐의 소요 시간
     * time_prev : 이전 퍼즐의 소요 시간
     * level : 숙련도
     * limit : 전체 제한 시간
    */
    
    public int solution(int[] diffs, int[] times, long limit) {
        // time_prev 메모이제이션
        int[] time_prev = new int[times.length];
        
        for(int i=1; i<times.length; i++) {
            time_prev[i] = times[i-1];
        }
        
        // 이분탐색으로 target(level) 최솟값 계산
        int answer = Integer.MAX_VALUE;
        int left = 1;
        int right = 100000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(isAvailable(diffs, times, time_prev, limit, mid)) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }
        
        // 제한 시간 내 퍼즐을 모두 해결하기 위한 숙련도의 최솟값
        return answer;
    }
    
    private boolean isAvailable(int[] diffs, int[] times, int[] time_prev, long limit, int level) {
        long total = 0;
        
        for(int i=0; i<diffs.length; i++) {
            int diff = diffs[i];
            int t_cur = times[i];
            int t_prev = time_prev[i];
            
            if(diff <= level) {
                total += t_cur;
            } else {
                int repeat = diff - level;
                total += (long) ((t_prev + t_cur) * repeat + t_cur);
            }
        }
        
        return total <= limit;
    }
}