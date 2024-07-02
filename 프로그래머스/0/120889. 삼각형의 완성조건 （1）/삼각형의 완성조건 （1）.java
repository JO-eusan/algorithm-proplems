class Solution {
    public int solution(int[] sides) {
        
        int max = 0;
        if(sides[max] < sides[1]) max = 1;
        if(sides[max] < sides[2]) max = 2;
        
        int other_sum = 0;
        for(int i=0; i<3; i++){
            if(i != max)
                other_sum += sides[i];
        }
        
        int answer = sides[max] < other_sum ? 1 : 2;
        
        return answer;
    }
}