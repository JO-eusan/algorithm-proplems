import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int lineNumber = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();

        for(int i=0; i<N.length(); i++) {
            if (i != 0 && i % lineNumber == 0) {
                System.out.println();
            }
            System.out.print(N.charAt(i));
        }
    }
}