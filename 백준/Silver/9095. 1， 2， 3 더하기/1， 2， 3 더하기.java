
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // n -> 1, 2, 3의 합으로 표현
        // 1 = 1가지 (1)
        // 2 = 2가지 (1 + 1, 2)
        // 3 = 4가지 (1 + 1 + 1, 1 + 2, 2 + 1, 3)
        // 4 = 4가지 + 2가지 + 1가지 = 7가지 (4-1 + 1, 4-2 + 2, 4-3 + 3)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11 + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}