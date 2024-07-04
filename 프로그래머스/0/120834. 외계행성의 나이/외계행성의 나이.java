class Solution {
    public String solution(int age) {
        String tmp = "";
        
        for(int i=1; age/i != 0; age/=10) {
            switch(age%(i*10)){
                case 0:
                    tmp += 'a'; break;
                case 1:
                    tmp += 'b'; break;
                case 2:
                    tmp += 'c'; break;
                case 3:
                    tmp += 'd'; break;
                case 4:
                    tmp += 'e'; break;
                case 5:
                    tmp += 'f'; break;
                case 6:
                    tmp += 'g'; break;
                case 7:
                    tmp += 'h'; break;
                case 8:
                    tmp += 'i'; break;
                case 9:
                    tmp += 'j'; break;
            }
        }
        
        String answer = "";
        for(int i=tmp.length()-1; i >= 0; i--)
            answer += tmp.charAt(i);
        
        return answer;
    }
}