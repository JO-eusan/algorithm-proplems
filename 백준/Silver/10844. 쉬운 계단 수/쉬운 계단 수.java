import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];

        /* initialize */
        dp[1][0] = 0;
        for(int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        /* DP */
        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                if(j>0) dp[i][j] += dp[i-1][j-1];
                if(j<9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= 1000000000;
            }
        }

        /* sum */
        long sum = 0;
        for(int i=0; i<10; i++) {
            sum += dp[N][i];
        }

        bw.write(String.valueOf(sum % 1000000000));

        bw.flush();
        bw.close();
    }
}