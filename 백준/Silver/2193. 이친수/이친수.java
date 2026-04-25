
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][2]; // [i][0]: 0으로 끝나는 숫자 수, [i][1]: 1로 끝나는 숫자 수

        dp[0][1] = 1;
        dp[1][1] = 1;

        for(int n=2; n<N; n++) {
            dp[n][0] += (dp[n-1][0] + dp[n-1][1]);
            dp[n][1] = dp[n-1][0];
        }

        System.out.println(2 * dp[N-1][0] + dp[N-1][1]);
    }
}