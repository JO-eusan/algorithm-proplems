import java.util.*;

class Solution {
    public int solution(int n) {
        int number = (int)(Math.sqrt(n) * 10);
        
        int answer = number%10 == 0 ? 1 : 2;
        
        return answer;
    }
}