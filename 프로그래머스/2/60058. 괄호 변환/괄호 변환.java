import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recursive(p);
        return answer;
    }
    
    private String recursive(String w) {
        if (w.isBlank()) {
            return "";
        }
        
        // u가 최소 길이의 "균형잡힌 괄호 문자열"가 되는 v의 시작 인덱스
        int idx = findBalancedLastIndex(w);
        String u = w.substring(0, idx);
        String v = w.substring(idx);
        
        if (isCorrect(u)) {
            return u + recursive(v);
        }
        return "(" + recursive(v) + ")" + removeAndReverse(u);
    }
    
    private int findBalancedLastIndex(String str) {
        int leftCount = 0;
        int rightCount = 0;
        
        int idx = 0;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                rightCount++;
            }
            
            if (leftCount == rightCount) {
                idx = i + 1;
                break;
            }
        }
        return idx;
    }
    
    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private String removeAndReverse(String str) {
        String center = str.substring(1, str.length()-1);
        String result = "";
        
        for (int i=0; i<center.length(); i++) {
            char c = center.charAt(i);
            if (c == '(') {
                result += ")";
            } else if (c == ')') {
                result += "(";
            }
        }
        return result;
    }
}