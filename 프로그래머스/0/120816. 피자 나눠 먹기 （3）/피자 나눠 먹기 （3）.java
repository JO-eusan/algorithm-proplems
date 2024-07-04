class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        
        double pizza = (double)n / slice;
        if((int)pizza < pizza && pizza < (int)pizza+1) answer++;
        
        answer += (int)pizza;
        
        return answer;
    }
}