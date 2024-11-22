import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        int[][] sum = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            sum[i][0] = Integer.parseInt(tmp[0]);
            for(int j=1; j<N; j++) {
                sum[i][j] = sum[i][j-1] + Integer.parseInt(tmp[j]);
            }
        }

        for(int i=0; i<M; i++) {
            String[] XY = br.readLine().split(" ");
            int x1 = Integer.parseInt(XY[0]) - 1;
            int y1 = Integer.parseInt(XY[1]) - 1;
            int x2 = Integer.parseInt(XY[2]) - 1;
            int y2 = Integer.parseInt(XY[3]) - 1;

            int result = 0;
            for(int x=x1; x<=x2; x++) {
                if(y1 == 0) {
                    result += sum[x][y2];
                }
                else {
                    result += sum[x][y2] - sum[x][y1-1];
                }
            }
            bw.write(String.valueOf(result) + "\n");
        }

        bw.flush();
        bw.close();
    }
}