import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        for(int i=0; i<10; i++) {
            int tmp = result + Integer.parseInt(br.readLine());

            if (Math.abs(tmp - 100) <= Math.abs(result - 100)) {
                result = tmp;
            } else break;
        }

        System.out.println(result);
    }
}