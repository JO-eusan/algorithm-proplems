import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        String[] second_line = br.readLine().split(" ");
        int[] sum_numbers = new int[N+1];
        for(int i=1; i<=N; i++) {
            sum_numbers[i] = sum_numbers[i-1] + Integer.parseInt(second_line[i-1]);
        }

        for(int m=0; m<M; m++) {
            String[] line = br.readLine().split(" ");
            int i = Integer.parseInt(line[0]);
            int j = Integer.parseInt(line[1]);

            int sum = sum_numbers[j] - sum_numbers[i-1];

            bw.write(String.valueOf(sum) + "\n");
        }

        bw.flush();
        bw.close();
    }
}