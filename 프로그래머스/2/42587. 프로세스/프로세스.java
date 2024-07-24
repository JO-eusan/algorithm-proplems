import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 우선순위 큐를 내림차순 정렬로 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) 
            pq.add(priorities[i]);
        
        // 우선순위 큐에 대한 순서대로 location 앞에 꺼내지는 요소 세기
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) { 
                    if (i == location) {
                        answer++;
                        return answer;
                    }   
                    pq.poll();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}