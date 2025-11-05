class Solution {
    public String solution(String s) {
        String answer = String.valueOf(s.charAt(0)).toUpperCase();
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i - 1) == ' ') {
                answer += String.valueOf(s.charAt(i)).toUpperCase();
            } else {
                answer += String.valueOf(s.charAt(i)).toLowerCase();
            }
        }
        return answer;
    }
}