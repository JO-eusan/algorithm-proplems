
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 2xn 크기의 직사각형을 1x2 or 2x1 타일로 채우는 방법의 수
        // n=1 : 2x1 = 1가지
        // n=2 : 2x1 2개, 1x2 2개 = 2가지
        // n=3 : 3가지 = 1가지 + 2가지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[Math.max(3, N+1)];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[N] % 10007);
    }
}