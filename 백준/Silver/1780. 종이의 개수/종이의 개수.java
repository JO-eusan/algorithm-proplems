import java.io.*;

public class Main {
    static int[][] board;
    static int minusOneCount;
    static int zeroCount;
    static int oneCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] tokens = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        divide_paper(0, 0, N);
        bw.write(String.valueOf(minusOneCount) + "\n");
        bw.write(String.valueOf(zeroCount) + "\n");
        bw.write(String.valueOf(oneCount) + "\n");

        bw.flush();
        bw.close();
    }

    private static void divide_paper(int startX, int startY, int N) {
        if(checkBoard(startX, startY, N)) {
            switch(board[startX][startY]) {
                case -1 :
                    minusOneCount++;
                    break;
                case 0 :
                    zeroCount++;
                    break;
                case 1 :
                    oneCount++;
                    break;
            }
            return;
        }

        int newN = N/3;

        divide_paper(startX, startY, newN);
        divide_paper(startX, startY+newN, newN);
        divide_paper(startX, startY+newN*2, newN);
        divide_paper(startX+newN, startY, newN);
        divide_paper(startX+newN, startY+newN, newN);
        divide_paper(startX+newN, startY+newN*2, newN);
        divide_paper(startX+newN*2, startY, newN);
        divide_paper(startX+newN*2, startY+newN, newN);
        divide_paper(startX+newN*2, startY+newN*2, newN);
    }

    private static boolean checkBoard(int startX, int startY, int N) {
        int checker = board[startX][startY];
        for(int i = startX; i < startX + N; i++) {
            for(int j = startY; j < startY + N; j++) {
                if(checker != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}