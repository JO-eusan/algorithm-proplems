import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시점이 빠른 순서대로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 작업 소요 시간을 기준으로 minHeap 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> (o1[1]-o2[1]));
        
        int sec = 0; // 현재 시점 count
        int idx = 0; // 현재 확인 idx
        int count = 0; // 수행 완료 요청 개수 -> job.length 일때 끝
        
        /* count */
        while(count < jobs.length) {
            // 배열의 idx의 요소의 시작 시점이 현재 시작 시점보다 작은 요소 put
            while(idx < jobs.length && jobs[idx][0] <= sec)
                minHeap.offer(jobs[idx++]);
                
            if(minHeap.isEmpty()) {
                // 초를 가장 빠르게 넣어야 하는 요소의 요청되는 시점으로 이동
                sec = jobs[idx][0];
            }
            else {
                int[] tmp = minHeap.poll();
                answer += tmp[1] + sec - tmp[0];
                sec += tmp[1];
                count++;
            }
        }
        
        answer /= jobs.length;
        
        return answer;
    }
}