import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        traversal(M, N, 0, "");

        bw.flush();
        bw.close();
    }

    public static void traversal(int M, int N, int prev, String num) throws IOException {

        if(M == 0) {
            bw.write(num + "\n");
            return;
        }

        for(int i=prev; i<N; i++) {
            if(num.equals("")) traversal(M-1, N, i, String.valueOf(i+1));
            else traversal(M-1, N, i, num + " " + (i+1));
        }
    }
}