import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> factor = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(n%i == 0) factor.add(i);
        }
        
        int[] answer = new int[factor.size()];
        for(int i=0; i<factor.size(); i++)
            answer[i] = factor.get(i);
        
        return answer;
    }
}