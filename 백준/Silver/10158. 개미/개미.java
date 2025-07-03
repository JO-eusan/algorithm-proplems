import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int w;
    public static int h;
    public static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] w_h = br.readLine().split(" ");
        String[] p_q = br.readLine().split(" ");

        int w = Integer.parseInt(w_h[0]);
        int h = Integer.parseInt(w_h[1]);

        int p = Integer.parseInt(p_q[0]);
        int q = Integer.parseInt(p_q[1]);

        int t = Integer.parseInt(br.readLine());

        p = (p + t) % (2 * w);
        q = (q + t) % (2 * h);

        if (p > w) {
            p = w - (p - w);
        }
        if (q > h) {
            q = h - (q - h); 
        }
        
        bw.write(String.format("%d %d", p, q));

        bw.flush();
        bw.close();
    }
}