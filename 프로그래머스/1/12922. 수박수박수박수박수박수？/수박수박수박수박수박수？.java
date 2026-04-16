class Solution {
    public String solution(int n) {
        String answer = "";
        
        int count = 0;
        while (count + 2 <= n) {
            answer += "수박";
            count += 2;
        }
        
        if (n - count == 1) {
            answer += "수";
        }
        
        return answer;
    }
}