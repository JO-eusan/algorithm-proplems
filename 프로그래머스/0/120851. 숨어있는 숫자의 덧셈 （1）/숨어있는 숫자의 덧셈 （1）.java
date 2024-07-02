class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        for(int i=0; i<my_string.length(); i++){
            switch(my_string.charAt(i)){
                case '1': answer+=1; break;
                case '2': answer+=2; break;
                case '3': answer+=3; break;
                case '4': answer+=4; break;
                case '5': answer+=5; break;
                case '6': answer+=6; break;
                case '7': answer+=7; break;
                case '8': answer+=8; break;
                case '9': answer+=9; break;
            }
        }
        return answer;
    }
}