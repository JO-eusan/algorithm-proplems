import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        int[] dp = new int[N];

        for(int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            lines[i][0] = Integer.parseInt(tmp[0]);
            lines[i][1] = Integer.parseInt(tmp[1]);
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
            }
        });

        int maxCounter = 0;
        Arrays.fill(dp, 1);
        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCounter = Math.max(maxCounter, dp[i]);
        }
        bw.write(String.valueOf(N - maxCounter));

        bw.flush();
        bw.close();
    }
}