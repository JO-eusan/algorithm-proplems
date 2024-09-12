import java.io.*;
import java.util.Arrays;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        board = new char[N][N]; // N x N board 만들기
        for(int n=0; n<N; n++) { // board를 *로 채우기 -> recur에서 공백 부분 check
            Arrays.fill(board[n], '*');
        }

        recur(N, 0, 0);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void recur(int N, int startX, int startY) {

        if(N == 1) return;

        int nextN = N/3;

        // 기존의 판을 3칸 x 3칸으로 나누어 좌표 부여
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                // 가운데 칸이면 공백 board에 추가
                if(i == 1 && j == 1) { 
                    for(int a=startX + nextN; a<startX + 2*nextN; a++) {
                        for(int b=startY + nextN; b<startY + 2*nextN; b++) {
                            board[a][b] = ' '; // 공백
                        }
                    }
                }
                else {
                    recur(nextN, startX + i*nextN, startY + j*nextN);
                }
            }
        }
    }
}