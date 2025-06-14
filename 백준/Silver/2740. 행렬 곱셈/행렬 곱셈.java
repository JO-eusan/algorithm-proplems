import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens_A = br.readLine().split(" ");
        int N = Integer.parseInt(tokens_A[0]);
        int M_A = Integer.parseInt(tokens_A[1]);

        int[][] A = new int[N][M_A];
        for(int i=0; i<N; i++) {
            String[] tmps = br.readLine().split(" ");
            for(int j=0; j<M_A; j++) {
                A[i][j] = Integer.parseInt(tmps[j]);
            }
        }

        String[] tokens_B = br.readLine().split(" ");
        int M_B = Integer.parseInt(tokens_B[0]);
        int K = Integer.parseInt(tokens_B[1]);

        int[][] B = new int[M_B][K];
        for(int i=0; i<M_B; i++) {
            String[] tmps = br.readLine().split(" ");
            for(int j=0; j<K; j++) {
                B[i][j] = Integer.parseInt(tmps[j]);
            }
        }

        int[][] result = new int[N][K];
        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                for(int k=0; k<M_A; k++) {
                    result[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                System.out.print((result[i][j]) + " ");
            }
            System.out.println();
        }
    }
}