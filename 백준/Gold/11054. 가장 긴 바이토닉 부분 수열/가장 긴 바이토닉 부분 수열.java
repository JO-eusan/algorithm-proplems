import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }

        int[][] dp = new int[N][2];

        dp[0][0] = 1;
        for(int i=1; i<N; i++) {
            dp[i][0] = 1;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i])
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
            }
        }

        dp[N-1][1] = 1;
        for(int i=N-2; i>=0; i--) {
            dp[i][1] = 1;
            for(int j=N-1; j>i; j--) {
                if(nums[j] < nums[i])
                    dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            max = Math.max(max, dp[i][0] + dp[i][1]);
        }

        bw.write(String.valueOf(max - 1));

        bw.flush();
        bw.close();
    }
}