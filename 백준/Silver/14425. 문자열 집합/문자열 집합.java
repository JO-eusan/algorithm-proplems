import java.util.*;
import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        String[] S = new String[N];

        int M = Integer.parseInt(tmp[1]);
        String[] str = new String[M];

        for(int i=0; i<N; i++)
            S[i] = br.readLine();

        for(int i=0; i<M; i++)
            str[i] = br.readLine();

        Arrays.sort(S); // 알파벳 사전 순으로 정렬

        // binary search
        int count = 0;
        loop: for(int i=0; i<M; i++)
        {
            String key = str[i];
            int fp = 0; int bp = N-1;

             while(fp <= bp)
            {
                int cp = (fp+bp)/2;

                if(S[cp].equals(key))
                {
                    count++;
                    continue loop;
                }
                else if(S[cp].compareTo(key) < 0) fp = cp + 1;
                else if(S[cp].compareTo(key) > 0) bp = cp - 1;
            }
        }

        bw.write(String.valueOf(count));
       
        bw.flush();
        bw.close();
    }    
}