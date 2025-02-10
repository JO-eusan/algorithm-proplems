import java.io.*;

class Main {
    public static int whiteCnt = 0;
    public static int blueCnt = 0;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] tokens = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        divide_and_conquer(N, 0, 0);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    public static void divide_and_conquer(int N, int startRow, int startCol) {
        if(check_board(N, startRow, startCol)) {
            /* 해당 색의 카운터 증가 */
            if(board[startRow][startCol] == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
            return;
        }
        
        int newSize = N/2;
        divide_and_conquer(newSize, startRow, startCol);
        divide_and_conquer(newSize, startRow, startCol + newSize);
        divide_and_conquer(newSize, startRow + newSize, startCol);
        divide_and_conquer(newSize, startRow + newSize, startCol + newSize);
    }

    public static boolean check_board(int N, int startRow, int startCol) {
        int white_tmp = 0;
        int blue_tmp = 0;

        for(int i=startRow; i<startRow + N; i++) {
            for(int j=startCol; j<startCol + N; j++) {
                if(board[i][j] == 0) {
                    white_tmp++;
                } else {
                    blue_tmp++;
                }
            }
        }
        return (white_tmp == N * N) || (blue_tmp == N * N);
    }
}