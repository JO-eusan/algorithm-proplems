import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 1. 스코빌 지수를 우선순위 큐에 넣는다.
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            q.offer(scoville[i]);
        }
        
        // 2. 스코빌 지수가 가장 낮은 값이 K 이상이 될 때까지 음식을 섞는다.
        while (q.peek() < K) {
            // 불가능한 경우 -1을 반환
            if (q.size() == 1) {
                answer = -1;
                break;
            }
            int n1 = q.poll();
            int n2 = q.poll();
            q.offer(n1 + (n2 * 2));
            
            answer++;
        }
        
        return answer;
    }
}