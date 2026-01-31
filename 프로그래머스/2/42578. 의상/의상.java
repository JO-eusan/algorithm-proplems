import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. clothes를 종류(key) - 개수(value)로 수집한다.
        Map<String, Integer> categories = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            categories.put(category, categories.getOrDefault(category, 0) + 1);
        }
        
        // 2. 각 종류를 선택할 경우의 수를 구한다.
        // 결과: (종류의 개수 + 1)의 곱에 전체가 선택되지 않는 경우 1을 뺀 값
        int answer = 1;
        
        for (String category : categories.keySet()) {
            answer *= (categories.get(category) + 1);
        }
        return answer - 1;
    }
}