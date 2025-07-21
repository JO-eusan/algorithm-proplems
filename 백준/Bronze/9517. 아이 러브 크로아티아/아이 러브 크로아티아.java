import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MAX_NUM = 210;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int time = 0;
        for(int i=0; i<N; i++) {
            String[] tmps = br.readLine().split(" ");

            int timeTmp = Integer.parseInt(tmps[0]);
            time += timeTmp;

            if (time > MAX_NUM) {
                break;
            }
            if (tmps[1].equals("T")) {
                K++;
            }
            if (K == 9) {
                K = 1;
            }
        }
        
        System.out.println(K);
    }
}