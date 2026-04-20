import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int nowBudget = budget;
        
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++) {
            if (d[i] <= nowBudget) {
                answer++;
                nowBudget -=  d[i];
            }
        }
        
        return answer;
    }
}