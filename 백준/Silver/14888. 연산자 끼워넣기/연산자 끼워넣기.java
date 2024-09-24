import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> cal_result = new ArrayList<>();
    static int N;
    static int[] numbers;
    static String[] poss_op; // 총 사용해야 할 연산자
    static boolean[] visited_op; // 중복을 제한하기 위한 방문 처리

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        poss_op = new String[N-1];
        visited_op = new boolean[N-1];

        /* 피연산자 */
        numbers = new int[N];
        String[] second_line = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(second_line[i]);
        }

        /* 연산자 개수 */
        String[] op = {"+", "-", "*", "/"};
        int idx_op = 0;
        String[] third_line = br.readLine().split(" ");

        for(int i=0; i<4; i++) {
            int tmp = Integer.parseInt(third_line[i]);

            for(int j=0; j<tmp; j++) {
                poss_op[idx_op++] = op[i];
            }
        }

        op_sequence(0, numbers[0]); // dfs

        /* 최대값 & 최소값 찾기 */
        Collections.sort(cal_result);

        bw.write(cal_result.get(cal_result.size() - 1) + "\n"); // max
        bw.write(cal_result.get(0) + "\n"); // min

        bw.flush();
        bw.close();
    }

    public static void op_sequence(int cnt, int num) {

        if(cnt == N-1) {
            cal_result.add(num);
            return;
        }

        for(int i=0; i<N-1; i++) {
            if(!visited_op[i]) {
                visited_op[i] = true;
                op_sequence(cnt + 1, calculate(num, numbers[cnt + 1], poss_op[i]));
                visited_op[i] = false;
            }
        }
    }

    public static int calculate(int x, int y, String op) {
        int result = 0;

        if(op.equals("+"))
            result = x + y;
        else if(op.equals("-"))
            result = x - y;
        else if(op.equals("*"))
            result = x * y;
        else if(op.equals("/"))
            result = x / y;

        return result;
    }
}