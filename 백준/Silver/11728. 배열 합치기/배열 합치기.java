
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N + M];
        int size = 0;
        int idxA = 0;
        int idxB = 0;
        
        while (idxA < N && idxB < M) {
            if (A[idxA] < B[idxB]) {
                result[size] = A[idxA];
                idxA++;
                size++;
            } else {
                result[size] = B[idxB];
                idxB++;
                size++;
            }
        }

        for(int i=idxA; i<N; i++) {
            result[size++] = A[i];
        }
        for(int i=idxB; i<M; i++) {
            result[size++] = B[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}