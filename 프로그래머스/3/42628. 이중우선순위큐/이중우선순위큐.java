import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2]; // [최댓값, 최솟값]
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소값을 위한 힙
        PriorityQueue<Integer> maxHeap 
            = new PriorityQueue<>(Collections.reverseOrder()); //최대값을 위한 힙
        
        int count_add = 0;
        int count_delete = 0;
        
        for(int i=0; i<operations.length; i++) {
            String[] tmp = operations[i].split(" ");
            
            if(tmp[0].equals("I")) {
                minHeap.offer(Integer.parseInt(tmp[1]));
                maxHeap.offer(Integer.parseInt(tmp[1]));
                count_add++;
            }
            else if(tmp[0].equals("D")) {
                if(minHeap.size() > 0) {
                    if(tmp[1].equals("1")) {
                        // 최대값 삭제
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    }
                    else { //-1
                        // 최소값 삭제
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                    count_delete++;
                }
            }
        }
        
        if(count_add - count_delete > 0) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        
        return answer;
    }
}