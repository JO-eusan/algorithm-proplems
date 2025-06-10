import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String[] tokens = br.readLine().split(" ");
        int A = Integer.parseInt(tokens[0]);
        int B = Integer.parseInt(tokens[1]);
        int C = Integer.parseInt(tokens[2]);

        bw.write(String.valueOf(pow(A, B, C)));

        bw.flush();
        bw.close();
    }

    public static long pow(int A, int B, int C) {
        if (B == 1) {
            return A % C;
        }

        long half = pow(A, B / 2, C);
        if (B % 2 == 0) {
            return half * half % C; 
        } else {
            return (half * half % C) * A % C;
        }
    }
}