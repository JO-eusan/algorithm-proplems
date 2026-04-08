
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            int t = Integer.parseInt(br.readLine());

            Map<String, List<String>> map = new HashMap<>();

            for(int i=0; i<t; i++) {
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String category = st.nextToken();

                List<String> curr = map.getOrDefault(category, new ArrayList<>());
                curr.add(name);

                map.put(category, curr);
            }

            int sum = 1;
            for(String k : map.keySet()) {
                sum *= map.get(k).size() + 1;
            }

            System.out.println(sum - 1);
        }
    }
}