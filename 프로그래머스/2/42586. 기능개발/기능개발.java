import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counter = new ArrayList<>();
        int today = 0;
        
        // 1. 가장 우선 순위가 높은 작업이 가장 위에 있게 stack을 구성한다.
        Stack<int[]> stack = new Stack<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push(new int[] {progresses[i], speeds[i]});
        }
        
        // 2. stack의 요소가 다 없어질 때까지 작업을 반복한다.
        while (!stack.isEmpty()) {
            // 3. 가장 위에 있는 pop하고 배포가 되는 시점을 계산한다.
            int[] progress = stack.pop();
            int duration = (int) Math.ceil((100 - progress[0]) / (double) progress[1]);
            counter.add(1);
            
            // 4. 배포 완료 시점에 배포가 가능한 작업까지 pop한다.
            while (!stack.isEmpty()) {
                int[] nextProgress = stack.peek();
                if (nextProgress[0] + duration * nextProgress[1] < 100) {
                    break;
                }
                stack.pop();
                
                // 5. 완료된 작업의 개수만큼 정답에 기록한다.
                counter.add(counter.remove(today) + 1);
            }
            today++;
        }
        return counter.stream().mapToInt(i -> i).toArray();
    }
}