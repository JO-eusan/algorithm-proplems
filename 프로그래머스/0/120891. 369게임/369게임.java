class Solution {
    public int solution(int order) {
        int answer = 0;
        
        for(int i=1; order/i != 0; order/=10){
            if(order%10 == 3 || order%10 == 6 || order%10 == 9)
                answer++;
        }
        return answer;
    }
}