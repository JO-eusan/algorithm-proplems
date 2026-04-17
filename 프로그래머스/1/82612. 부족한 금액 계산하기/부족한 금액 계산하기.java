class Solution {
    public long solution(int price, int money, int count) {
        long needed = 0;
        for(int i=1; i<=count; i++) {
            needed += (price * i);
        }
        
        long answer = 0;
        if (money - needed < 0) {
            answer = needed - money;
        }
        
        return answer;
    }
}