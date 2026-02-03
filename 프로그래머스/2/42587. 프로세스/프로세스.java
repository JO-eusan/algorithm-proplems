import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }
        
        int order = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigherPriority = false;
            for (int[] q : queue) {
                if (q[0] > current[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if (hasHigherPriority) {
                // 다시 뒤로 보냄
                queue.offer(current);
            } else {
                // 실행
                order++;
                if (current[1] == location) {
                    return order;
                }
            }
        }
        return -1;
    }
}