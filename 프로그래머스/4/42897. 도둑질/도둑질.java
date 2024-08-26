class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] start_0 = new int[money.length];
        int[] start_1 = new int[money.length];
        
        //초기화
        for(int i=0; i<money.length; i++) {
            start_0[i] = money[i];
            start_1[i] = money[i];
        }
        
        //못가는 집은 -1로 표시
        start_0[1] = -1;
        start_1[0] = -1;
        start_0[2] += start_0[0];
        
        //DP start
        for(int i=3; i<money.length; i++) {
            start_0[i] += Math.max(start_0[i-2], start_0[i-3]);
            start_1[i] += Math.max(start_1[i-2], start_1[i-3]);
        }
        
        int max_0 = Math.max(start_0[money.length-2], start_0[money.length-3]);
        int max_1 = Math.max(start_1[money.length-1], start_1[money.length-2]);
        
        answer = Math.max(max_0, max_1);
        
        return answer;
    }
}