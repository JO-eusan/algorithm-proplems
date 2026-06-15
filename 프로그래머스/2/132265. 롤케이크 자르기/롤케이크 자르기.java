import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int[] left_counter = new int[topping.length];
        int[] right_counter = new int[topping.length];
        
        Set<Integer> category = new HashSet<>();
        
        for(int i=0; i<topping.length; i++) {
            category.add(topping[i]);
            left_counter[i] = category.size();
        }
        
        category = new HashSet<>();
        for(int i=topping.length-1; i>=0; i--) {
            category.add(topping[i]);
            right_counter[i] = category.size();
        }
        
        int answer = 0;
        for(int i=0; i<topping.length-1; i++) {
            if(left_counter[i] == right_counter[i+1]) {
                answer++;
            }
        }
        return answer;
    }
}