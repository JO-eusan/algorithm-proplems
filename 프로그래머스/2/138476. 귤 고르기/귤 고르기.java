import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> counter = new HashMap<>();
        
        for(int t : tangerine) {
            counter.put(t, counter.getOrDefault(t, 0) + 1);
        }
        
        PriorityQueue<Integer> key = new PriorityQueue<>((a, b) -> counter.get(b) - counter.get(a));
        
        for(int t : counter.keySet()) {
            key.add(t);
        }
        
        int answer = 0;
        int neededTangerine = k;
        
        while (neededTangerine > 0) {
            int choosed = key.poll();
            neededTangerine -= counter.get(choosed);
            
            answer++;
        }
        
        return answer;
    }
}