class Solution {
    public int solution(int chicken) {
        int coupon = 0;
        for(int i = 0; i < chicken; i++) {
            coupon++;
            if(coupon % 10 == 0)
                coupon++;
        }
        int answer = coupon/10;
        
        return answer;
    }
}