import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int diff = B.length() - A.length();

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= diff; i++) {
            int candidate = calculate(A, B.substring(i, i + A.length()));
            if (candidate < min) {
                min = candidate;
            }
        }
        System.out.println(min);
    }

    private static int calculate(String A, String B) {
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}