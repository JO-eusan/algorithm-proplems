import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int A = Integer.parseInt(first_line[0]);
        int B = Integer.parseInt(first_line[1]);

        HashSet<Integer> A_set = new HashSet<>();
        HashSet<Integer> common = new HashSet<>();

        String[] second_line = br.readLine().split(" ");
        for(int i=0; i<A; i++)
            A_set.add(Integer.parseInt(second_line[i]));
        
        String[] third_line = br.readLine().split(" ");
        for(int i=0; i<B; i++)
        {
            if(A_set.contains(Integer.parseInt(third_line[i])))
                common.add(Integer.parseInt(third_line[i]));
        }

        bw.write(String.valueOf(A+B - 2*common.size()));


        bw.flush();
        bw.close();
    }
}