import java.io.*;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";

        while(((input = br.readLine()) != null) && (input.length() > 0)) {
            int N = Integer.parseInt(input);

            sb = new StringBuilder();
            for(int i=0; i<(int)Math.pow(3.0, N); i++) {
                sb.append('-');
            }

            kanto(0, N);

            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void kanto(int start, int N) { // start ~ start + 3^N - 1

        int powNum = (int)Math.pow(3, N);

        if(N == 0) return;
        
        for(int i=start + powNum/3; i<start + 2*powNum/3; i++) {
            sb.setCharAt(i, ' ');
        }
        
        kanto(start, N-1);
        kanto(start + 2*powNum/3, N-1);
    }
}