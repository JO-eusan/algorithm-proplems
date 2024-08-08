import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        int n = number.length() - k;
        
        for(int i=0; i<number.length(); i++) {
            char current_c = number.charAt(i);
            
            // 스택의 마지막 숫자보다 현재 숫자가 크면 제거하고 k를 감소 -> 제거 숫자를 선택
            while(!stack.isEmpty() && k>0 && stack.peek() < current_c) {
                stack.pop();
                k--;
            }
            stack.push(current_c);
        }
        
        // 아직 제거해야 할 숫자가 남아 있는 경우 뒤에서 제거
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택에 남아 있는 숫자로 문자열 만들기
        Character[] numbers = new Character[n];
        for(int i=0; i<n; i++) {
            numbers[n - i - 1] = stack.pop();
        }
        
        for(int i=0; i<n; i++) {
            answer += numbers[i];
        }
        
        return answer;
    }
}