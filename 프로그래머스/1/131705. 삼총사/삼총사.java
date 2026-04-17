class Solution {
    
    private int answer = 0;
    
    public int solution(int[] number) {
        dfs(0, 0, 0, number);
        return answer;
    }
    
    private void dfs(int start, int depth, int sum, int[] number) {
        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }
        
        for(int i=start; i<number.length; i++) {
            dfs(i+1, depth+1, sum+number[i], number);
        }
    }
}