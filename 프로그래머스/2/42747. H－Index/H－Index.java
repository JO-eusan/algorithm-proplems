import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] wrapper_arr = new Integer[citations.length];
        for(int i=0; i<citations.length; i++)
            wrapper_arr[i] = citations[i];
        
        Arrays.sort(wrapper_arr, Collections.reverseOrder());
        
        int h = 10000;
        for(; h>=0; h--) {

            /* 기준 이상 논문 수 세기 */
            int paper_over_k = 0;
            for(int j=0; j<citations.length; j++) {
                if(wrapper_arr[j] >= h) paper_over_k++;
            }
            
            if(paper_over_k >= h) break;
        }
        
        answer = h;
        
        return answer;
    }
}