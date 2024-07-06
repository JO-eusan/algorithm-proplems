class Solution {
    public int solution(int n) {
        int answer = 1;
        int current_result = 1;
        
        while(n >= current_result) {
            ++answer;
            current_result *= answer;
        }
        
        return answer - 1;
    }
}