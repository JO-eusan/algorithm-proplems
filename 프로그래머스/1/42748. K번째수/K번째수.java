import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int n=0; n<commands.length; n++) {
            
            int i=commands[n][0]; int j=commands[n][1]; int k=commands[n][2];
            
            /* 배열 자르기 */
            int[] tmp = new int[j-i+1];
            int idx = 0;
            for(int t=i-1; t<=j-1; t++) {
                tmp[idx++] = array[t];
            }
            
            /* 정렬 */
            Arrays.sort(tmp);
            
            answer[n] = tmp[k-1];
        }
        
        return answer;
    }
}