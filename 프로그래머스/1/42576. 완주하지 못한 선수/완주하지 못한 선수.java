import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. participant에 대해 이름별 참여자 횟수를 만듭니다.
        Map<String, Integer> people = new HashMap<>();
        for (String p : participant) {
            Integer countValue = people.putIfAbsent(p, 1);
            if (countValue != null) {
                people.put(p, countValue + 1);
            }
        }
        
        // 2. completion을 O(n)으로 순회하면서 참여자 명단에서 제외합니다.
        for (String c : completion) {
            Integer countValue = people.putIfAbsent(c, 0);
            if (countValue != null) {
                people.put(c, countValue - 1);
            }
        }
        
        // 3. participant에 유일하게 남아있는 이름(key)를 출력합니다.
        String answer = "";
        for (String k : people.keySet()) {
            if (people.get(k) != 0) {
                answer = k;
            }
        }
        return answer;
    }
}