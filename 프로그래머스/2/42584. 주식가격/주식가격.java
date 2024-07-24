class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++) {
            int tmp = 0;
            for(int j=i+1; j<prices.length; j++) {
                tmp++;
                if(prices[j] < prices[i]) // 가격 떨어지면
                    break;
            }
            answer[i] = tmp;
        }
        
        answer[prices.length-1] = 0;
        
        return answer;
    }
}