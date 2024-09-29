import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] tile = new int[N+1];
        tile[1] = 1; // f(1) = 1 -> 1
        if(N != 1) tile[2] = 2; // f(2) = 2 -> 00 , 11

        for(int i=3; i<=N; i++) {
            tile[i] = (tile[i-1] + tile[i-2]) % 15746;
        }

        bw.write(String.valueOf(tile[N] % 15746));

        bw.flush();
        bw.close();
    }
}