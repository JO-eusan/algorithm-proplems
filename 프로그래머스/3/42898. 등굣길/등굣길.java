class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int limit_mod = 1000000007;
        
        int[][] board = new int[n+1][m+1];
        
        //puddles을 -1로 표시
        for(int i=0; i<puddles.length; i++) {
            board[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        //(1,1)을 1로 초기화
        board[1][1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(i==1 && j==1) continue;
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else
                    board[i][j] = (board[i-1][j] + board[i][j-1]) % limit_mod;
            }
        }
        
        answer = board[n][m];
        
        return answer % limit_mod;
    }
}