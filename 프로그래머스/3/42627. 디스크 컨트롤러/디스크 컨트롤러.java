import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 요청 시각으로 정렬된 처리되지 않은 작업을 저장할 공간을 지정한다.
        PriorityQueue<Integer> tasks = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return jobs[o1][0] - jobs[o2][0];
            }
        });
        
        // 2. 현재 작업의 번호를 처리되지 않은 작업 큐에 저장한다.
        for (int i=0; i<jobs.length; i++) {
            tasks.offer(i);
        }
        
        // 3. time을 갱신하면서 그 시점에 작업이 가능한 대기 큐를 구성하고 우선순위가 가장 높은 작업을 처리한다.
        PriorityQueue<Integer> availableTasks = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (jobs[o1][1] != jobs[o2][1]) {
                    return jobs[o1][1] - jobs[o2][1];
                }
                if (jobs[o1][0] != jobs[o1][0]) {
                    return jobs[o1][0] - jobs[o2][1];
                }
                return o1 - o2;
            }
        });
        int time = 0;
        int totalReturnTime = 0;
        
        while (tasks.size() != 0 || availableTasks.size() != 0) {
            while (!tasks.isEmpty() && jobs[tasks.peek()][0] <= time) {
                availableTasks.offer(tasks.poll());
            }
            
            if (!availableTasks.isEmpty()) {
                int process = availableTasks.poll();
                time += jobs[process][1];
                totalReturnTime += (time - jobs[process][0]);
            } else if (!tasks.isEmpty()) {
                time = jobs[tasks.peek()][0];
            }
        }
        
        // 4. 모든 요청 작업의 반환 시간을 계산한다.
        return totalReturnTime / jobs.length;
    }
}