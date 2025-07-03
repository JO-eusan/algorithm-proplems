import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int w;
    public static int h;
    public static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmps = br.readLine().split(" ");
        int[] moneys = new int[4];
        for(int i=1; i<=3; i++) {
            moneys[i] = Integer.parseInt(tmps[i - 1]) * i;
        }

        int[] timeCounter = new int[101];
        for(int i=0; i<3; i++) {
            String[] times = br.readLine().split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            for(int j=start; j<end; j++) {
                timeCounter[j]++;
            }
        }

        int result = 0;
        for(int i=1; i<=100; i++) {
            int counter = timeCounter[i];
            result += moneys[counter];
        }

        System.out.println(result);
    }
}