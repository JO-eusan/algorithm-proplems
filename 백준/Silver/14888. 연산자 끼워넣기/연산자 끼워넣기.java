import java.io.*;
import java.util.*;

public class Main {

    static List<String> sequence = new ArrayList<>(); // 연산자의 순서
    static int N;
    static String[] poss_op; // 총 사용해야 할 연산자
    static boolean[] visited_op; // 중복을 제한하기 위한 방문 처리

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        poss_op = new String[N-1];
        visited_op = new boolean[N-1];

        /* 피연산자 */
        int[] numbers = new int[N];
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

        op_sequence(0, ""); // dfs

        /* 연산자와 피연산자를 이용하여 연산 시작 */
        List<Integer> cal_result = new ArrayList<>();
        for(int n=0; n<sequence.size(); n++) {

            // 하나의 연산자 순서에 대해서 계산하기
            String[] ops = sequence.get(n).split(" ");
            int result = numbers[0];

            for(int i=0; i<N-1; i++) {
                result = calculate(result, numbers[i+1], ops[i]);
            }

            cal_result.add(result);
        }
        


        /* 최대값 & 최소값 찾기 */
        Collections.sort(cal_result);

        bw.write(cal_result.get(cal_result.size() - 1) + "\n"); // max
        bw.write(cal_result.get(0) + "\n"); // min

        bw.flush();
        bw.close();
    }

    public static void op_sequence(int cnt, String str) {

        if(cnt == N-1) {
            sequence.add(str);
            return;
        }

        for(int i=0; i<N-1; i++) {
            if(!visited_op[i]) {
                visited_op[i] = true;

                if(str.equals("")) op_sequence(cnt + 1, poss_op[i]);
                else op_sequence(cnt + 1, str + " " + poss_op[i]);
                
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