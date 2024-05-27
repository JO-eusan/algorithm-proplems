import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 5;

        List<Integer> array = new ArrayList<>();

        int sum = 0;
        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sum += tmp;
            array.add(tmp);
        }

        Collections.sort(array);

        bw.write(String.valueOf(sum/5) + "\n");
        bw.write(String.valueOf(array.get(2)));

        bw.flush();
        bw.close();
    }
}