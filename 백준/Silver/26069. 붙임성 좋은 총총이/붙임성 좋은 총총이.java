import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> dancing = new HashSet<>();

        dancing.add("ChongChong");

        for(int i=0; i<N; i++)
        {
            String[] pairs = br.readLine().split(" ");

            if(dancing.contains(pairs[0]) && dancing.contains(pairs[1]))
                continue;
            else if(dancing.contains(pairs[0]))
                dancing.add(pairs[1]);
            else if(dancing.contains(pairs[1]))
                dancing.add(pairs[0]);
        }

        bw.write(String.valueOf(dancing.size()));

        bw.flush();
        bw.close();
    }    
}