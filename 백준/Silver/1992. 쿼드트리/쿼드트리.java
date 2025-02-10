import java.io.*;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] tokens = br.readLine().split("");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        divide_and_conquer(N, 0, 0);
    }

    private static void divide_and_conquer(int N, int startRow, int startCol) {
        if(check_board(N, startRow, startCol)) {
            System.out.print(String.valueOf(board[startRow][startCol]));
        } else {
            System.out.print("(");

            int newSize = N/2;
            divide_and_conquer(newSize, startRow, startCol);
            divide_and_conquer(newSize, startRow, startCol + newSize);
            divide_and_conquer(newSize, startRow + newSize, startCol);
            divide_and_conquer(newSize, startRow + newSize, startCol + newSize);

            System.out.print(")");
        }
    }

    private static boolean check_board(int N, int startRow, int startCol) {
        int black_tmp = 0;
        int white_tmp = 0;

        for(int i=startRow; i<startRow + N; i++) {
            for(int j=startCol; j<startCol + N; j++) {
                if(board[i][j] == 0) {
                    white_tmp++;
                } else {
                    black_tmp++;
                }
            }
        }
        return (white_tmp == N * N) || (black_tmp == N * N);
    }
}