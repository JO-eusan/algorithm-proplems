import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[1] = numbers[1];
        
        if(N>=2) {
            dp[2] = numbers[1] + numbers[2];
        }

        for(int i=3; i<=N; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + numbers[i-1]) + numbers[i];
        }

        bw.write(String.valueOf(dp[N]));

        bw.flush();
        bw.close();
    }
}