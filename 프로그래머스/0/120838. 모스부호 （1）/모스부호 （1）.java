import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        
        String[] moss = letter.split(" ");
        for(int i=0; i<moss.length; i++) {
            String tmp = moss[i];
            /* 알파벳 변환 */
            if(tmp.equals(".-")) answer += 'a';
            else if(tmp.equals("-...")) answer += 'b';
            else if(tmp.equals("-.-.")) answer += 'c';
            else if(tmp.equals("-..")) answer += 'd';
            else if(tmp.equals(".")) answer += 'e';
            else if(tmp.equals("..-.")) answer += 'f';
            else if(tmp.equals("--.")) answer += 'g';
            else if(tmp.equals("....")) answer += 'h';
            else if(tmp.equals("..")) answer += 'i';
            else if(tmp.equals(".---")) answer += 'j';
            else if(tmp.equals("-.-")) answer += 'k';
            else if(tmp.equals(".-..")) answer += 'l';
            else if(tmp.equals("--")) answer += 'm';
            else if(tmp.equals("-.")) answer += 'n';
            else if(tmp.equals("---")) answer += 'o';
            else if(tmp.equals(".--.")) answer += 'p';
            else if(tmp.equals("--.-")) answer += 'q';
            else if(tmp.equals(".-.")) answer += 'r';
            else if(tmp.equals("...")) answer += 's';
            else if(tmp.equals("-")) answer += 't';
            else if(tmp.equals("..-")) answer += 'u';
            else if(tmp.equals("...-")) answer += 'v';
            else if(tmp.equals(".--")) answer += 'w';
            else if(tmp.equals("-..-")) answer += 'x';
            else if(tmp.equals("-.--")) answer += 'y';
            else if(tmp.equals("--..")) answer += 'z';
        }
        
        return answer;
    }
}