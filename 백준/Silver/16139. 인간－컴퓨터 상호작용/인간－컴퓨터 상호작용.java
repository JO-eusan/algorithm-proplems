import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int ALPHA = 'z' - 'a' + 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[ALPHA][str.length()];

        for(int i=0; i<ALPHA; i++) {
            if(i == str.charAt(0) - 'a') {
                dp[i][0] = 1;
            }

            for(int j=1; j<str.length(); j++) {
                dp[i][j] = dp[i][j-1];
                if(i == str.charAt(j) - 'a') {
                    dp[i][j]++;
                }
            }
        }

        for(int n=0; n<N; n++) {
            String[] tmp = br.readLine().split(" ");
            int find_char = tmp[0].charAt(0) - 'a';
            int i = Integer.parseInt(tmp[1]);
            int j = Integer.parseInt(tmp[2]);

            int result = dp[find_char][j];
            if(i > 0) {
                result -= dp[find_char][i-1];
            }
            bw.write(String.valueOf(result) + "\n");
        }

        bw.flush();
        bw.close();
    }
}