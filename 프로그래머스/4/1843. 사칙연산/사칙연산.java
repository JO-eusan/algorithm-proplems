import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        
        int[] num = new int[arr.length / 2 + 1]; // 피연산자
        int[] op = new int[arr.length / 2]; // 연산자 [0:+, 1:-]
        
        int idx1 = 0;
        int idx2 = 0;
        
        for(String cur : arr) {
            if(cur.equals("+"))
                op[idx2++] = 0;
            else if(cur.equals("-"))
                op[idx2++] = 1;
            else
                num[idx1++] = Integer.parseInt(cur);
        }
        
        /* DP start */
        
        // dp[a][b][0] : a~b까지 최소값
        // dp[a][b][1] : a~b까지 최대값
        int[][][] dp = new int[num.length][num.length][2];
        
        for(int i=0; i<dp.length; i++) {
            /* 자기 자신만 괄호 - 결과: 자기자신 */
            dp[i][i][0] = num[i];
            dp[i][i][1] = num[i];
        }
        
        for(int len=1; len<dp.length; len++) {
            for(int s=0; s<dp.length; s++) {
                
                if(s + len >= dp.length) break;
                
                int e = s + len;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int i=s; i<e; i++) {
                    // (+)
                    if(op[i] == 0) {
                        max = Math.max(max, dp[s][i][1] + dp[i+1][e][1]);
                        min = Math.min(min, dp[s][i][0] + dp[i+1][e][0]);
                    }
                    
                    // (-)
                    if(op[i] == 1) {
                        max = Math.max(max, dp[s][i][1] - dp[i+1][e][0]);
                        min = Math.min(min, dp[s][i][0] - dp[i+1][e][1]);
                    }
                }
                dp[s][e][0] = min;
                dp[s][e][1] = max;
            }
        }
        
        
        answer = dp[0][arr.length / 2][1];
        
        return answer;
    }
}