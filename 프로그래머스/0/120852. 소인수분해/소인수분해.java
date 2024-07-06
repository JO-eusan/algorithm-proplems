import java.util.*;

class Solution {
    public int[] solution(int n) {
        HashSet<Integer> factors = new HashSet<>();
        
        int k = 2;
        while(n/k != 0) {
            if(n%k == 0) {
                factors.add(k);
                n /= k;
                continue;
            }
            k++;
        }
        
        Integer[] tmp = factors.toArray(new Integer[0]);
        int[] answer = new int[tmp.length];
        for(int i=0; i<answer.length; i++) 
            answer[i] = (int)tmp[i];
        
        Arrays.sort(answer);
        
        
        return answer;
    }
}