import java.io.*;

public class Main {

    static int N;
    static int count;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        /* 가능 여부를 알려주는 보드 만들기 */
        board = new int[N][N];

        n_queen(0);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }

    public static void n_queen(int cnt) { 
        /* 
         * cnt는 queen 둘 자리를 선택할 열을 의미
         * cnt = 0 : 0번째 열
         * cnt = 1 : 1번째 열
         * ... N-1번째 열까지 반복
         */

        if(cnt == N) {
            count++;
            return;
        }

        // queen을 둘 자리를 선택하는 반복문
        for(int i=0; i<N; i++) { 
            if(board[i][cnt] == 0) {
                
                /* queen의 규칙으로 대각선 및 직선 칸을 모두 사용 불가능 처리 */
                for(int j=0; j<N; j++) {
                    
                    board[i][j]++; // 가로
                    board[j][cnt]++; // 세로

                    if((0 <= i + cnt - j) && (i + cnt - j < N)) 
                        board[i + cnt - j][j]++; // 우측 대각선
                    if((0 <= i - cnt + j) && (i - cnt + j < N))
                        board[i - cnt + j][j]++; // 좌측 대각선
                }
                
                n_queen(cnt + 1);

                /* queen의 규칙으로 대각선 및 직선 칸을 모두 복구 */
                for(int j=0; j<N; j++) {
                    
                    board[i][j]--; // 가로
                    board[j][cnt]--; // 세로

                    if((0 <= i + cnt - j) && (i + cnt - j < N)) 
                        board[i + cnt - j][j]--; // 우측 대각선
                    if((0 <= i - cnt + j) && (i - cnt + j < N))
                        board[i - cnt + j][j]--; // 좌측 대각선
                }
            }   
        }
    }
}