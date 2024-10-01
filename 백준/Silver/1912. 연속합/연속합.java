import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); 
        int[] originals = new int[N];

        String[] first_line = br.readLine().split(" ");
        for(int n=0; n<N; n++) {
            originals[n] = Integer.parseInt(first_line[n]);
        }

        int local_max = originals[0];
        int global_max = originals[0];

        for(int i=1; i<N; i++) {
            local_max = Math.max(originals[i], originals[i] + local_max);
            global_max = Math.max(global_max, local_max);
        }

        bw.write(String.valueOf(global_max));
        
        bw.flush();
        bw.close();
    }
}