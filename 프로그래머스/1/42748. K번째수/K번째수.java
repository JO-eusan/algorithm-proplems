import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int n=0; n<commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            int idx = 0;
            int[] tmp = new int[j - i + 1];
            for(int m=i-1; m<=j-1; m++) {
                tmp[idx++] = array[m];
            }
            
            Arrays.sort(tmp);
            answer[n] = tmp[k - 1];
        }
        
        return answer;
    }
}