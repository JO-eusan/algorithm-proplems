import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int k = Integer.parseInt(first_line[1]);

        List<Integer> array = new ArrayList<>();
        
        String[] second_line = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            array.add(Integer.parseInt(second_line[i]));
        }

        Collections.sort(array, Comparator.reverseOrder());

        bw.write(String.valueOf(array.get(k-1)));

        bw.flush();
        bw.close();
    }
}