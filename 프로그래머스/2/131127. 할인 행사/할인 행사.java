import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> bucket = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            bucket.put(want[i], number[i]);
        }
        
        for(int i=0; i<10; i++) {
            String target = discount[i];
            bucket.put(target, bucket.getOrDefault(target, 0) - 1);
        }
        
        int answer = 0;
        if(isTotalDiscount(bucket)) {
            answer++;
        }
        
        for(int i=10; i<discount.length; i++) {
            String pop = discount[i-10];
            String push = discount[i];
            
            bucket.put(pop, bucket.getOrDefault(pop, 0) + 1);
            bucket.put(push, bucket.getOrDefault(push, 0) - 1);
            
            if(isTotalDiscount(bucket)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isTotalDiscount(Map<String, Integer> bucket) {
        for(Integer v : bucket.values()) {
            if(v > 0) {
                return false;
            } 
        }
        return true;
    }
}