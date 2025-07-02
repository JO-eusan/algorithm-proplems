import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] tokens = br.readLine().split(" ");

            int n = Integer.parseInt(tokens[0]);
            int[] numbers = new int[n];

            int sum = 0;
            for(int j=0; j<n; j++) {
                numbers[j] = Integer.parseInt(tokens[j + 1]);
                sum += numbers[j];
            }

            double average = 1.0 * sum / n;

            int counter = 0;
            for(int j=0; j<n; j++) {
                if (numbers[j] > average) {
                    counter++;
                }
            }

            System.out.printf("%.3f", (1.0 * counter / n) * 100);
            System.out.println("%");
        }
    }
}