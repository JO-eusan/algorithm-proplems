import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int count_truck = 0;
        int weight_sum = 0; // 현재 다리 위의 트럭의 총 무게
        int truck_idx = 0; // 현재 트럭
        
        Queue<Integer> q = new LinkedList<>();
        
        while(count_truck != truck_weights.length) { // 모든 차가 나올 때까지 반복
            
            answer++; // 1초 증가
            
            /* 트럭 탈출 */
            if(q.size() == bridge_length) {
                int tmp = q.poll();
                weight_sum -= tmp;
                if(tmp != 0) count_truck++;
            }
            
            /* 트럭 투입 */
            if((truck_idx < truck_weights.length) 
               && (truck_weights[truck_idx] + weight_sum <= weight)) {
                q.offer(truck_weights[truck_idx]);
                weight_sum += truck_weights[truck_idx];
                truck_idx++;
            }
            else q.offer(0);
            
            
            
            
        }
        
        
        
        return answer;
    }
}