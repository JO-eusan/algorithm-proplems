import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        //적어도 가장 빨리 처리하는 심사대가 1명 처리하는 시간 이상은 걸린다.
        long start = times[0]; 
        //최악의 경우는 가장 오래 걸리는 심사대가 모든 사람들을 처리하는 경우이다.
        long end = (long)times[times.length-1] * n;
        
        while(start <= end) {
            long mid = (start + end) / 2;
        
            //mid의 시간동안 몇 명의 사람을 처리할 수 있는지 확인   
            long sum = 0;
            for(int time : times) {
                sum += mid/time;
            }
            
            if(sum >= n) { // n명 이상의 사람을 처리 가능
                answer = mid;
                end = mid - 1;
            }
            else { // 더 많은 사람 처리 필요
                start = mid + 1;
            }
        }
        
        
        
        return answer;
    }
}