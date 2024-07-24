import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        /* min heap을 통해 가장 작은 요소 2개를 뽑고 결과를 put */
        /* 가장 작은 요소 (tree의 root)가 K 이상까지 반복 */
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) 
            minHeap.offer(scoville[i]);
        
        while(minHeap.peek() < K) {
            
            if(minHeap.size() == 1) {
                answer = -1;
                break;
            }
            
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            
            minHeap.offer(min1 + min2*2);
            answer++;
        }
        
        return answer;
    }
}