import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 0) 
            bw.write(1 + "\n");
        else
            bw.write(factorial(N) + "\n");
    
        bw.flush();
        bw.close();
    }

    public static long factorial(int N) {
        if(N == 1) return 1;
        return factorial(N-1) * N;
    }
}