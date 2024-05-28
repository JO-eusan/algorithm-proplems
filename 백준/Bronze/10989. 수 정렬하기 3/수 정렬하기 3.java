import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            array[i] = tmp;
        }

        Arrays.sort(array);
        for(int i=0; i<N; i++)
            bw.write(String.valueOf(array[i]) + "\n");

        bw.flush();
        bw.close();
    }
}