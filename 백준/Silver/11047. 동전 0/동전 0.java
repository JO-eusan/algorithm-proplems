import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        int value = 0;
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<N; i++) {
            value = Integer.parseInt(br.readLine());

            if(value <= K) values.add(value);
        }

        int counter = 0;
        for(int i=values.size()-1; K != 0; i--) {
            counter += K / values.get(i);
            K = K % values.get(i);
        }

        bw.write(String.valueOf(counter));

        bw.flush();
        bw.close();
    }
}