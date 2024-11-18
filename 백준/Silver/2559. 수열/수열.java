import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int K = Integer.parseInt(first_line[1]);
        int max_sum = Integer.MIN_VALUE;

        String[] second_line = br.readLine().split(" ");
        int[] numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(second_line[i]);
        }

        for(int i=0; i<=N-K; i++) {
            int sum = 0;
            for(int j=i; j<i+K; j++) {
                sum += numbers[j];
            }
            max_sum = Math.max(max_sum, sum);
        }
        bw.write(String.valueOf(max_sum));

        bw.flush();
        bw.close();
    }
}