class Solution {
    
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, 0, 0);
        return max;
    }
    
    private void dfs(int hp, int[][] dungeons, int mask, int cnt) {
        if(mask == (1<<dungeons.length) - 1) {
            max = Math.max(max, cnt);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if((mask & (1<<i)) == 0) {
                // 피로도 조건이 맞다면 던전 탐험
                if(hp >= dungeons[i][0]) {
                    dfs(hp-dungeons[i][1], dungeons, mask | (1<<i), cnt+1);
                } else {
                    // 아니라면 방문 체크만
                    dfs(hp, dungeons, mask | (1<<i), cnt);
                }
            }
        }
    }
}