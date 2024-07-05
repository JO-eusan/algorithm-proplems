class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        for(int n=1; n<=emergency.length; n++) {
            int max_idx = 0;
            for(int i=1; i<emergency.length; i++) {
                if(emergency[max_idx] < emergency[i])
                    max_idx = i;
            }
            emergency[max_idx] = 0;
            answer[max_idx] = n;
        }
        
        return answer;
    }
}