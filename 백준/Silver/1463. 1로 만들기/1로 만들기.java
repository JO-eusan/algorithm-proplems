import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        if(N == 2) dp[2] = 1; 
        else if(N > 2) {
            dp[2] = 1; // 2 / 2 = 1
            dp[3] = 1; // 3 / 3 = 1

            for(int i=4; i<=N; i++) {

                int min = Integer.MAX_VALUE;
    
                for(int j=3; j>0; j--) {
                    if(j != 1 && i % j == 0) {
                        min = Math.min(min, 1 + dp[i/j]);
                        dp[i] = min;
                    }
                    else if(j == 1) {
                        min = Math.min(min, 1 + dp[i-1]);
                        dp[i] = min;
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
    }
}