import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][3];
        for(int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");

            for(int j=0; j<3; j++) {
                costs[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int i=1; i<N; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        bw.write(String.valueOf(Math.min(costs[N-1][0], Math.min(costs[N-1][1], costs[N-1][2]))));
        
        bw.flush();
        bw.close();
    }
}