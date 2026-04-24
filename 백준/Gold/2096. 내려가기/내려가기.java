
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][3];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j=0; j<3; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] maxSum = new int[N][3];
        int[][] minSum = new int[N][3];

        maxSum[0][0] = minSum[0][0] = nums[0][0];
        maxSum[0][1] = minSum[0][1] = nums[0][1];
        maxSum[0][2] = minSum[0][2] = nums[0][2];

        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                switch (j) {
                    case 0:
                        maxSum[i][j] = nums[i][j] + Math.max(maxSum[i-1][j], maxSum[i-1][j+1]);
                        minSum[i][j] = nums[i][j] + Math.min(minSum[i-1][j], minSum[i-1][j+1]);
                        break;
                    case 1:
                        maxSum[i][j] = nums[i][j] + Math.max(maxSum[i-1][j], Math.max(maxSum[i-1][j-1], maxSum[i-1][j+1]));
                        minSum[i][j] = nums[i][j] + Math.min(minSum[i-1][j], Math.min(minSum[i-1][j-1], minSum[i-1][j+1]));
                        break;
                    case 2: 
                        maxSum[i][j] = nums[i][j] + Math.max(maxSum[i-1][j], maxSum[i-1][j-1]);
                        minSum[i][j] = nums[i][j] + Math.min(minSum[i-1][j], minSum[i-1][j-1]);
                        break;
                }
            }
        }

        System.out.println(Math.max(maxSum[N-1][0], Math.max(maxSum[N-1][1], maxSum[N-1][2])) + " " + Math.min(minSum[N-1][0], Math.min(minSum[N-1][1], minSum[N-1][2])));
    }
}