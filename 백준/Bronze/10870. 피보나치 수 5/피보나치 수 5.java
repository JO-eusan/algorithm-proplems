import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 0) 
            bw.write(0 + "\n");
        else if(N == 1)
            bw.write(1 + "\n");
        else
            bw.write(fibonacci(N) + "\n");
    
        bw.flush();
        bw.close();
    }

    public static int fibonacci(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;

        return fibonacci(N-1) + fibonacci(N-2);
    }
}