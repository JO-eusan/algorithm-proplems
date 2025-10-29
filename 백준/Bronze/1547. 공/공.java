import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        /* 컵 번호 초기화 */
        List<Integer> cups = new ArrayList<>();
        cups.add(1);
        cups.add(2);
        cups.add(3);

        for(int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int indexX = cups.indexOf(X);
            int indexY = cups.indexOf(Y);

            int tmp = X;
            cups.add(indexX, Y);
            cups.add(indexY, tmp);
        }
        System.out.println(cups.get(0));
    }   
}