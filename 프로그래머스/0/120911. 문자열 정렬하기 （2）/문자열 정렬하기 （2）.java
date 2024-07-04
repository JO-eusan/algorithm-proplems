import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        /* 소문자로 변경 */
        my_string = my_string.toLowerCase();
        
        /* 정렬 */
        char[] str = new char[my_string.length()];
        for(int i=0; i<my_string.length(); i++) {
            str[i] = my_string.charAt(i);
        }
        
        Arrays.sort(str);
        
        for(int i=0; i<str.length; i++) 
            answer += str[i];
        
        return answer;
    }
}