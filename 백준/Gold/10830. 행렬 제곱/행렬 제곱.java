import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        long B = Long.parseLong(firstLine[1]);

        A = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] tmps = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(tmps[j]) % 1000;
            }
        }

        int[][] result = powForMatrix(B);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] powForMatrix(long pow) {
        if(pow == 1) {
            return A;
        }

        int[][] divided = powForMatrix(pow/2);
        divided = multiply(divided, divided);

        if (pow % 2 == 1) { // 홀수인 제곱수는 한 번 더 연산
            return multiply(divided, A);
        } 
        return divided;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int N = a.length;
        int[][] result = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    result[i][j] += (a[i][k] * b[k][j]);
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}