import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        Arrays.sort(array);
        
        // n과의 간격을 저장하는 배열
        int[] interval_n = new int[array.length];
        for(int i=0; i<array.length; i++)
            interval_n[i] = Math.abs(array[i] - n);
        
        // 최소값의 index가 정답
        int min_idx = 0;
        for(int i=1; i<array.length; i++) {
            if(interval_n[min_idx] > interval_n[i])
                min_idx = i;
        }
        
        answer = array[min_idx];
        return answer;
    }
}