
import java.io.*;
import java.util.*;

public class Main {

    static List<int[]>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> nums = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                bw.write((nums.contains(Integer.parseInt(st.nextToken())) ? 1 : 0) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}