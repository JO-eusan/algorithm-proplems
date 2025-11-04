import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Set<String> results = new TreeSet<>(); // 자동 사전 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        /* 괄호 index pair 찾기 */
        List<int[]> pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(i);
            } else if (expression.charAt(i) == ')') {
                pairs.add(new int[] {stack.pop(), i});
            }
        }

        /* 백트래킹으로 모든 경우의 수를 출력 */
        dfs(0, pairs, expression, new boolean[expression.length()]);
        for(String result : results) {
            System.out.println(result);
        }
    }

    private static void dfs(int depth, List<int[]> pairs, String expresstion, boolean[] remove) {
        if (depth == pairs.size()) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < expresstion.length(); i++) {
                if (!remove[i]) {
                    sb.append(expresstion.charAt(i));
                }
            }

            String result = sb.toString();
            if (!result.equals(expresstion)) {
                results.add(result);
            }
            return;
        }

        int[] pair = pairs.get(depth);
        remove[pair[0]] = true;
        remove[pair[1]] = true;
        dfs(depth + 1, pairs, expresstion, remove);

        remove[pair[0]] = false;
        remove[pair[1]] = false;
        dfs(depth + 1, pairs, expresstion, remove);
    }
}