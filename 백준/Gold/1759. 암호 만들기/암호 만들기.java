import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int L;
    private static int C;
    private static Set<String> candidates = new TreeSet<>();
    private static List<Character> alphabets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i ++) {
            alphabets.add(st.nextToken().charAt(0));
        }

        dfs(0, "", "", 0);

        for(String candidate : candidates) {
            System.out.println(candidate);
        }
    }

    /*
     * vo: 포함된 모음
     * co: 포함된 자음
     */
    private static void dfs(int depth, String vo, String co, int startIndex) {
        if (depth == L) {
            if (vo.length() >= 1 && co.length() >= 2) {
                char[] fullText = (vo + co).toCharArray();
                Arrays.sort(fullText);
                candidates.add(new String(fullText));
            }
            return;
        }

        for(int i = startIndex; i < alphabets.size(); i++) {
            char alphabet = alphabets.get(i);
            if (!vo.contains(String.valueOf(alphabet)) && !co.contains(String.valueOf(alphabet))) {
                if (alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u') {
                    dfs(depth + 1, vo + String.valueOf(alphabet), co, i);
                } else {
                    dfs(depth + 1, vo, co + String.valueOf(alphabet), i);
                }   
            }
        }
    }
}