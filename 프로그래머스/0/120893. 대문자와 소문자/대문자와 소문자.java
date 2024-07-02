class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i=0; i<my_string.length(); i++){
            
            char current_char = my_string.charAt(i);
            int term = 'a'-'A';
            
            if('a'<=current_char && current_char <='z')
                answer += (char)(current_char - term);
            else
                answer+= (char)(current_char + term);
        }
        return answer;
    }
}