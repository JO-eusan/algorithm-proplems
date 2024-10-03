import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];

        triangle[0][0] = Integer.parseInt(br.readLine());

        for(int i=1; i<N; i++) {
            String[] tmp = br.readLine().split(" ");

            for(int j=0; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(tmp[j]);

                if(j == 0) triangle[i][j] += triangle[i-1][j];
                else if(j == i) triangle[i][j] += triangle[i-1][j-1];
                else triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        int max_sum = 0;
        for(int i=0; i<N; i++) {
            if(triangle[N-1][i] > max_sum)
                max_sum = triangle[N-1][i];
        }
        bw.write(String.valueOf(max_sum));

        bw.flush();
        bw.close();
    }
}