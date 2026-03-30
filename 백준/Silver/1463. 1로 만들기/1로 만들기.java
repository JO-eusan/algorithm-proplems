
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(4, N+1)];

        dp[1] = 0;
        dp[2] = dp[3] = 1;

        for(int i=4; i<=N; i++) {
            int minCount = dp[i-1];

            if (i % 3 == 0) {
                minCount = Math.min(dp[i/3], minCount);
            }
            if (i % 2 == 0) {
                minCount = Math.min(dp[i/2], minCount);
            }

            dp[i] = minCount + 1;
        }

        System.out.println(dp[N]);
    }
}