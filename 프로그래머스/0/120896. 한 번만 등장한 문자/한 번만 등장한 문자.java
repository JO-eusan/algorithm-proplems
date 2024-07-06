class Solution {
    public String solution(String s) {
        String answer = "";
        
        int[] characters = new int[26];
        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            characters[tmp-'a']++;
        }
        
        for(int i=0; i<26; i++) {
            if(characters[i] == 1)
                answer += (char)(i + 'a');
        }
        return answer;
    }
}