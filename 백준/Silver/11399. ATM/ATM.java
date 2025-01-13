import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];

        String[] tokens = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            times[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(times);

        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += times[i] * (N - i);
        }
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}