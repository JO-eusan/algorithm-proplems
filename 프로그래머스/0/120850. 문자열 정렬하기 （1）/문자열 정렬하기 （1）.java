import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        List<Character> numbers = new ArrayList<>();
        
        for(int i=0; i<my_string.length(); i++) {
            char tmp = my_string.charAt(i);
            if('0' <= tmp && tmp <= '9')
                numbers.add(tmp);
        }
        
        Collections.sort(numbers);
        
        int[] answer = new int[numbers.size()];
        for(int i=0; i<numbers.size(); i++) 
            answer[i] = numbers.get(i) - '0';
        
        return answer;
    }
}