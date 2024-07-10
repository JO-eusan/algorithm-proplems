import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        /* count할 자료구조 생성 */
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            if(!map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], 1);
            else
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        /* 조합 수 계산 */
        List<Integer> count = new ArrayList<Integer>(map.values());
        for(int i=0; i<count.size(); i++)
            answer *= (count.get(i) + 1);
        
        return answer-1;
    }
}