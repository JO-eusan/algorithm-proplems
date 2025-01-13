import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] times = new long[N][2]; // [start][end]

        for(int i=0; i<N; i++) {
            String[] tokens = br.readLine().split(" ");
            times[i][0] = Long.parseLong(tokens[0]);
            times[i][1] = Long.parseLong(tokens[1]);
        }

        Arrays.sort(times, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[1] == o2[1]) {
                    return (int)(o1[0] - o2[0]);
                }
                return (int)(o1[1] - o2[1]);
            }
        });

        int counter = 1; // 첫번째 작업 추가
        long nextStart = times[0][1];

        for(int i=1; i<N; i++) {
            if(times[i][0] >= nextStart) {
                counter++;
                nextStart = times[i][1];
            }
        }

        bw.write(String.valueOf(counter));

        bw.flush();
        bw.close();
    }
}