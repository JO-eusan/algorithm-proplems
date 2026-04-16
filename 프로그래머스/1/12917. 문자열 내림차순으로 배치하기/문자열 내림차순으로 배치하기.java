import java.util.*;

class Solution {
    public String solution(String s) {
        String[] alphabets = new String[s.length()];
        for(int i=0; i<s.length(); i++) {
            alphabets[i] = String.valueOf(s.charAt(i));
        }
        
        Arrays.sort(alphabets, Comparator.reverseOrder());
        
        String answer = "";
        for(int i=0; i<alphabets.length; i++) {
            answer += alphabets[i];
        }
        
        return answer;
    }
}