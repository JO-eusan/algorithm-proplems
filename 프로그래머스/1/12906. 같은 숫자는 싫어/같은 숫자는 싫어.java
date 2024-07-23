import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(stack.empty()) // 스택이 비어 있으면 무조건 push
                stack.push(arr[i]);
            else if(stack.peek() != arr[i]) // 마지막 push 값과 동일하면 pass 아니면 push
                stack.push(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        for(int i=0; i<answer.length; i++) {
            answer[answer.length - i - 1] = stack.pop();
        }
        
        return answer;
    }
}