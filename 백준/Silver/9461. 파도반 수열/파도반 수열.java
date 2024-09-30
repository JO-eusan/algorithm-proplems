import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 100; // N의 최대값 = 100

        long[] P = new long[N+1];
        P[0] = 0;
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;

        for(int i=5; i<=N; i++) {
            P[i] = P[i-1] + P[i-5];
        }

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(P[n]) + "\n");
        }

        bw.flush();
        bw.close();
    }
}