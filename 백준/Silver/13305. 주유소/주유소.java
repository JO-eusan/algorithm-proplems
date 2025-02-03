import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] distances = new int[N-1];
        int[] values = new int[N-1];

        String[] distances_str = br.readLine().split(" ");
        String[] values_str = br.readLine().split(" ");

        for(int i=0; i<N-1; i++) {
            distances[i] = Integer.parseInt(distances_str[i]);
            values[i] = Integer.parseInt(values_str[i]);
        }

        long sum = 0;
        int current_distance = distances[0];
        int current_value = values[0];
        for(int i=1; i<N-1; i++) {
            if(current_value > values[i]) {
                sum += (long)current_distance * current_value;
                current_distance = distances[i];
                current_value = values[i];
            } else {
                current_distance += distances[i];
            }
        }
        
        sum += (long)current_distance * current_value;
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}