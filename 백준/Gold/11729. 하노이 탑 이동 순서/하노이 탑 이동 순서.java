import java.io.*;
import java.util.*;

public class Main {

    static int count; // 이동 횟수
    static List<String> list = new ArrayList<>(); // 출력을 위한 결과 저장

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3);

        /* 출력 결과 */
        bw.write(count + "\n");
        for(int i=0; i<list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void hanoi(int N, int start, int end) {

        if(N == 1) {
            list.add(start + " " + end);
            count++;
            return;
        }

        int newEnd = 0;
        if((start == 1 && end == 2) || (start == 2 && end == 1))
            newEnd = 3;
        else if((start == 1 && end == 3) || (start == 3 && end == 1))
            newEnd = 2;
        else if((start == 2 && end == 3) || (start == 3 && end == 2))
            newEnd = 1;
        
        hanoi(N-1, start, newEnd);
        hanoi(1, start, end);
        hanoi(N-1, newEnd, end);
    }
}