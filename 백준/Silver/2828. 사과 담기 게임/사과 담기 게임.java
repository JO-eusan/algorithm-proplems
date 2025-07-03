import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int w;
    public static int h;
    public static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int J = Integer.parseInt(br.readLine());
        int start = 1;
        int end = M;

        int result = 0;

        for(int j=0; j<J; j++) {
            int tmp = Integer.parseInt(br.readLine());
            int distance = 0;

            if (end < tmp) {
                distance = tmp - end;
                start += distance;
                end += distance;
                result += distance;
            } else if (tmp < start) {
                distance = start - tmp;
                start -= distance;
                end -= distance;
                result += distance;
            }
        }

        System.out.println(result);
    }
}