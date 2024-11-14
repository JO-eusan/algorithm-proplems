import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int K = Integer.parseInt(first_line[1]);
        int[][] dp = new int[N+1][K+1];

        int[][] items = new int[N+1][2];
        for(int i=1; i<=N; i++) {
            String[] line = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(line[0]);
            items[i][1] = Integer.parseInt(line[1]);
        }

        /* dynamic programming */
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= K; j++) {
                if (items[i][0] <= j) {
                    dp[i][j] = dp[i - 1][j - items[i][0]] + items[i][1];
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }
        bw.write(String.valueOf(dp[N][K]));

        bw.flush();
        bw.close();
    }
}