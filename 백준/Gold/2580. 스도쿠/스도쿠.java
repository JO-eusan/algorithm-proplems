import java.io.*;
import java.util.*;

public class Main {

    static int[][] board = new int[9][9];
    static int zero_num;
    static List<int[]> blanks = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++) {
            String[] tmp = br.readLine().split(" ");

            for(int j=0; j<9; j++) {
                if(tmp[j].equals("0")) {
                    zero_num++;
                    blanks.add(new int[] {i, j});
                } 
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        sudoqu(0);
    }

    public static void sudoqu(int cnt) {

        if(cnt == zero_num) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);   
        }    

        // 유효 숫자 배열
        boolean[] numbers = new boolean[9];

        // 0 자리의 index 꺼내기
        int x = blanks.get(cnt)[0];
        int y = blanks.get(cnt)[1];
        
        for(int i=0; i<9; i++) {
            if(board[x][i] != 0)
                numbers[board[x][i] - 1] = true; // 가로 num 체크
            if(board[i][y] != 0)
                numbers[board[i][y] - 1] = true; // 세로 num 체크
        }
            
        // 사각형 num 체크
        int[] start_coor = squere_index(x, y);
        int startX = start_coor[0];
        int startY = start_coor[1];

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[startX + i][startY + j] != 0)
                    numbers[board[startX + i][startY + j] - 1] = true;
            }
        }
    
        /* 재귀호출 시작 -> 만약 한번도 나오지 않은 숫자라면 값을 채우고 호출 */
        for(int i=0; i<9; i++) {
            if(!numbers[i]) {
                board[x][y] = (i + 1); // 값 넣기
                sudoqu(cnt + 1);
                board[x][y] = 0; // 값 되돌리기
            }
        }

    }

    public static int[] squere_index(int x, int y) {
        int[] start_coor = new int[2];

        start_coor[0] = (x/3) * 3;
        start_coor[1] = (y/3) * 3;

        return start_coor;        
    }
    
}