import java.util.*;

class Solution {
    /*
    * diff = 현재 퍼즐의 난이도
    * time_cur = 현재 퍼즐의 소요시간
    * time_prev = 이전 퍼즐의 소요시간
    * level = 숙련도
    * limit = 전체 제한 시간
    */
    public int solution(int[] diffs, int[] times, long limit) {
        int max_diff = 1;
        for(int i=1; i<diffs.length; i++) {
            if(diffs[i] > max_diff) {
                max_diff = diffs[i];
            }
        }
        
        int left = 1;
        int right = max_diff;
        
        int level = max_diff;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(isAvailable(diffs, times, mid, limit)) {
                level = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    
        return level;
    }
    
    private boolean isAvailable(int[] diffs, int[] times, int level, long limit) {
        long total_time = times[0];
        
        for(int i=1; i<diffs.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            int time_prev = times[i-1];
            
            if(diff <= level) {
                total_time += time_cur;
            } else {
                total_time += (diff-level) * (time_cur+time_prev) + time_cur;
            }
        }
        
        return total_time <= limit;
    }
}