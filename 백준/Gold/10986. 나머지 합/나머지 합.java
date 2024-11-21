import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        String[] second_line = br.readLine().split(" ");
        long[] sum_numbers = new long[N];
        sum_numbers[0] = Long.parseLong(second_line[0]);
        for(int i=1; i<N; i++) {
            sum_numbers[i] = sum_numbers[i-1] + Long.parseLong(second_line[i]);
        }

        int[] remain_numbers = new int[M];
        for(int i=0; i<N; i++) {
            int index = (int)((sum_numbers[i] % M + M) % M);
            remain_numbers[index]++;
        }

        long result = remain_numbers[0];
        for(int i=0; i<M; i++) {
            long tmp = remain_numbers[i];
            result += (tmp * (tmp-1) / 2);
        }
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}