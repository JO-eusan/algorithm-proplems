import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        /* contains() 메서드 사용을 위해 HashMap으로 변환 */
        HashMap<String, Integer> comp = new HashMap<>();
        for(int i=0; i<completion.length; i++) {
            if(!comp.containsKey(completion[i]))
               comp.put(completion[i], 1);
            else
               comp.put(completion[i], comp.get(completion[i]) + 1);
        }
        
        for(int i=0; i<participant.length; i++) {
            if(!comp.containsKey(participant[i]))
            {
                answer = participant[i];
                break;
            }
            else if(comp.containsKey(participant[i]) && comp.get(participant[i]) == 0)
            {
                answer = participant[i];
                break;
            }
            else 
            {
                comp.put(participant[i], comp.get(participant[i]) - 1);
            }
        }
        
        return answer;
    }
}