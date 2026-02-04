import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 1. 최대 & 최소 정렬 큐 2개를 관리한다.
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        // 2. operations을 순회하면서 작업을 수행한다.
        for (String op : operations) {
            String[] tokens = op.split(" ");
            
            if (tokens[0].equals("I")) {
                maxQueue.offer(Integer.parseInt(tokens[1]));
                minQueue.offer(Integer.parseInt(tokens[1]));
            } else if (Integer.parseInt(tokens[1]) == 1) {
                minQueue.remove(maxQueue.poll());
            } else if (Integer.parseInt(tokens[1]) == -1) {
                maxQueue.remove(minQueue.poll());
            }
        }
        
        // 3. Queue에 남아있는 원소의 개수에 따라 결과 값을 반환한다.
        if (maxQueue.size() == 0) {
            return new int[] {0, 0};
        } else if (maxQueue.size() == 1) {
            int num = maxQueue.poll();
            return new int[] {num, num};
        } 
        return new int[] {maxQueue.poll(), minQueue.poll()};
    }
}