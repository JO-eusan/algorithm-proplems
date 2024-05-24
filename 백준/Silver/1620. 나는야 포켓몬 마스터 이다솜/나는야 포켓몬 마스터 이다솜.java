import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> key_name = new HashMap<>();
        HashMap<Integer, String> key_num = new HashMap<>();

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        for(int n=0; n<N; n++)
        {
            String str = br.readLine();
            key_name.put(str, n+1);
            key_num.put(n+1, str);
        }
        
        for(int m=0; m<M; m++)
        {
            String tmp = br.readLine();

            if('1'<=tmp.charAt(0) && tmp.charAt(0)<='9')
                bw.write(key_num.get(Integer.parseInt(tmp)));
            else
                bw.write(String.valueOf(key_name.get(tmp)));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}