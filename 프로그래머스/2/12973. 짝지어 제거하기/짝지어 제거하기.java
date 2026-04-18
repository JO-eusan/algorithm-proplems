import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
            char now = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(now);
            } else if (stack.peek() == now) {
                stack.pop();
            } else {
                stack.push(now);
            }
        }
        
        if (stack.size() == 0) {
            return 1;
        }
        return 0;
    }
}