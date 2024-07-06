import java.util.*;

class Solution {
    public int solution(String before, String after) {
        /* befor에서 after을 만들 수 있으려면 알파벳 종류와 그 수가 같아야 한다. */
        int answer = 1;
        
        int[] before_char = new int[26];
        int[] after_char = new int[26];
        
        for(int i=0; i<before.length(); i++) {
            char tmp_before = before.charAt(i);
            char tmp_after = after.charAt(i);
            
            before_char[tmp_before-'a']++;
            after_char[tmp_after-'a']++;
        }
        
        /* check */
        for(int i=0; i<26; i++) {
            if(before_char[i] != after_char[i])
                answer = 0;
        }
        
        return answer;
    }
}