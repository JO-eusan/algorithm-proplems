
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        long[] AB = new long[N * N];
        long[] CD = new long[N * N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
             idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        System.out.println(twoPointer(AB, CD));
    }

    public static long twoPointer(long[] AB, long[] CD) {
        int left = 0;
        int right = CD.length - 1;
        long count = 0;

        while (left < AB.length && right >= 0) {
            long total = AB[left] + CD[right];

            if (total == 0) {
                long aVal = AB[left];
                long bVal = CD[right];

                long cntA = 0;
                long cntB = 0;

                while (left < AB.length && AB[left] == aVal) {
                    cntA++;
                    left++;
                }

                while (right >= 0 && CD[right] == bVal) {
                    cntB++;
                    right--;
                }

                count += cntA * cntB;

            } else if (total < 0) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}