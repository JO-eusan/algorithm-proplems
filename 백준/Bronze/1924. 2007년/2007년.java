import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeeks = new String[] {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);

        int daysCounter = 0;
        for(int i=1; i<x; i++) {
            daysCounter += days[i];
        }
        daysCounter += y;

        System.out.println(dayOfWeeks[(daysCounter + 6) % 7]);
    }
}