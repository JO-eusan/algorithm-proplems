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

        int[] dp = new int[N];
        dp[0] = 1;
        int result = 1;

        for(int i=1; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }

            result = Math.max(result, dp[i]);
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}