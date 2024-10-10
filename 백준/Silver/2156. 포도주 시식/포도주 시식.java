import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];
        long[] dp = new long[N+1];

        /* initialize */
        for(int i=1; i<=N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        /* DP */
        if(N==1) {
            dp[1] = nums[1];
        }
        else {
            dp[1] = nums[1];
            dp[2] = nums[2] + nums[1];
        }

        for(int i=3; i<=N; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], nums[i] + dp[i-3] + nums[i-1]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        long max_result = 0;
        for(int i=1; i<=N; i++) {
            if(max_result < dp[i])
                max_result = dp[i];
        }

        bw.write(String.valueOf(max_result));

        bw.flush();
        bw.close();
    }
}