import java.io.*;

public class Main {

    static int[] f; 
    static int count_recur;
    static int count_dynamic;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        f = new int[n+1];

        count_recur++;
        count_dynamic++;

        fibonacci_recursive(n);
        fibonacci_dynamic(n);
        
        bw.write(String.valueOf(count_recur) + " " + String.valueOf(count_dynamic));

        bw.flush();
        bw.close();
    }

    /* 재귀 호출 */
    public static int fibonacci_recursive(int n) {
        if(n == 1 || n == 2) 
            return 1;
        else {
            count_recur++;
            return (fibonacci_recursive(n-1) + fibonacci_recursive(n-2));
        }
    }

    /* 동적 계획법 */
    public static int fibonacci_dynamic(int n) {
        f[1] = 1;
        f[2] = 1;

        for(int i=3; i<n; i++) {
            count_dynamic++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}