import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] token = s.split(" ");
        int post_number = 0;
        for(int i=0; i<token.length; i++) {
            if(token[i].equals("Z"))
                answer -= post_number;
            else {
                answer += Integer.parseInt(token[i]);
                post_number = Integer.parseInt(token[i]);
            }
        }
        return answer;
    }
}