import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        /* 스택이 비어 있는데 ")"를 push 해야 한다면 false */
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(!stack.empty()) {
                if(c == '(') stack.push('(');
                else if(c == ')') stack.pop();
            }
            else {
                if(c == '(') stack.push('(');
                else if(c == ')') answer = false;
            }
        }
        
        /* 올바른 괄호라면 stack이 최종적을 비어 있어야 한다. */
        if(!stack.empty()) answer = false;

        return answer;
    }
}