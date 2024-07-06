import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(int i=0; i<my_string.length(); i++) {
            String tmp = String.valueOf(my_string.charAt(i));
            
            if('0' <= tmp.charAt(0) && tmp.charAt(0) <= '9') {
                while(((i+1) < my_string.length()) && ('0' <= my_string.charAt(i+1) && my_string.charAt(i+1) <= '9')) {
                    i++;
                    tmp += String.valueOf(my_string.charAt(i));
                }
            
                answer += Integer.parseInt(tmp);
            }
        }
        return answer;
    }
}