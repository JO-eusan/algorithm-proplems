import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 5M + 1
        int N = Integer.parseInt(st.nextToken()); // 5N + 1
        
        String[][] board = new String[5 * M + 1][5 * N + 1];
        for(int i = 0; i < 5 * M + 1; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < line.length; j++) {
                board[i][j] = line[j];
            }
        }

        int[] counter = new int[5];
        for(int m = 0; m < M; m++) {
            for(int n = 0; n < N; n++) {
                for(int i = (5 * m + 1); i < (5 * m + 1) + 4; i++) {
                    if (board[i][5 * n + 1].equals(".")) {
                        counter[i % 5 - 1]++;
                        break;
                    }
                    if (i == 5 * m + 4 && board[i][5 * n + 1].equals("*")) {
                        counter[4]++;
                    }
                }
            }
        }

        for(int num : counter) {
            System.out.print(num + " ");
        }
    }
}