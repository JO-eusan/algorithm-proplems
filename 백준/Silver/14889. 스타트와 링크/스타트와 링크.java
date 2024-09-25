import java.io.*;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] visited;

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        /* S 생성 -> Sij + Sji 계산 */
        S = new int[N][N];
        for(int i=0; i<N; i++) {

            String[] line = br.readLine().split(" ");

            for(int j=0; j<N; j++) {
                if(i < j) S[i][j] += Integer.parseInt(line[j]);
                else S[j][i] += Integer.parseInt(line[j]);
            }
        }

        pick_player(0, 0);

        bw.write(min + "");

        bw.flush();
        bw.close();
    }

    public static void pick_player(int cnt, int prev) {

        if(cnt == N/2) {
            // 최소값 계산
            int team_1 = 0;
            int team_2 = 0;

            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    if(visited[i] && visited[j])
                        team_1 += S[i][j];
                    else if(!visited[i] && !visited[j])
                        team_2 += S[i][j];
                }
            }

            min = Math.min(min, Math.abs(team_1 - team_2));
            return;
        }

        for(int i=prev; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                pick_player(cnt + 1, i);
                visited[i] = false;
            }
        }
    }
}