import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer_list = new ArrayList<>(); // 정답을 위한 list
        Stack<Integer> stack = new Stack<>();
        
        /* 맨 끝 요소부터 stack에 push */
        for(int i=progresses.length-1; i>=0; i--)
            stack.push(progresses[i]);
        
        /* start count */
        int answer_count = 0; // 정답 요소
        int day_sum = 0; // 진행된 날짜
        
        for(int idx=0; idx<speeds.length; ) { 
            int element = stack.pop();
            int top = element + day_sum * speeds[idx]; 
           
            if(top >= 100) { // 배포 가능하면 count
                answer_count++;
                if(idx == speeds.length-1) answer_list.add(answer_count);
                idx++; // 다음 요소로 넘어감
            }
            else { // 배포 불가능하면 날짜 이동
                int day = (int)Math.ceil((100 - top) / (double)speeds[idx]);
                day_sum += day;
                stack.push(element); // 다시 확인 필요
                
                if(idx != 0) {
                    answer_list.add(answer_count);
                    answer_count = 0;
                }
            } 
        }
        
        /* list -> array */
        int[] answer = new int[answer_list.size()];
        for(int i=0; i<answer_list.size(); i++) 
            answer[i] = answer_list.get(i);
        
        return answer;
    }
}