import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        loop : for(int i=0; i<dic.length; i++){
            HashSet<String> used = new HashSet<>();
            for(int j=0; j<dic[i].length(); j++){
                used.add(String.valueOf(dic[i].charAt(j)));
            }
            
            for(int j=0; j<spell.length; j++){
                if(!used.contains(spell[j]))
                    continue loop;
            }
            answer = 1;
        }
        return answer;
    }
}