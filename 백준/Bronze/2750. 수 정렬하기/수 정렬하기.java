import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> array = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            array.add(tmp);
        }

        Collections.sort(array);

        for(int i=0; i<N; i++)
            bw.write(String.valueOf(array.get(i)) + "\n");
        

        bw.flush();
        bw.close();
    }
}