import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        // 1. 다리를 0으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        // 2. 아직 다리를 건너지 못한 트럭이 있으면 계속
        while (truckIndex < truck_weights.length) {
            time++;
            
            // 3. 1초 결과하면 맨 앞 트럭이 내려감
            currentWeight -= bridge.poll();
            
            // 4. 다음 트럭이 올라갈 수 있으면 해당 weight 넣고
            if (currentWeight + truck_weights[truckIndex] <= weight) {
                bridge.offer(truck_weights[truckIndex]);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                // 5. 못 올라간다면 빈 처리
                bridge.offer(0);
            }
        }
        
        // 6. 마지막 트럭이 올라간 뒤에 다리의 길이만큼 시간 더 필요
        return time + bridge_length;
    }
}