class Solution {
    public int solution(int num, int k) {
        String number_str = String.valueOf(num);
        int answer = number_str.indexOf(String.valueOf(k));
        
        if(answer != -1) answer++;
        
        return answer;
    }
}