import java.util.*;
import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<N; i++)
            cards[i] = Integer.parseInt(tmp[i]);

        int M = Integer.parseInt(br.readLine());
        int[] numbers = new int[M];

        tmp = br.readLine().split(" ");
        for(int i=0; i<M; i++)
            numbers[i] = Integer.parseInt(tmp[i]);

        Arrays.sort(cards);

        // binary search
        loop: for(int i=0; i<M; i++)
        {
            int key = numbers[i];
            int fp = 0; int bp = N-1;

             while(fp <= bp)
            {
                int cp = (fp+bp)/2;

                if(cards[cp] == key)
                {
                    bw.write(String.valueOf(1) + " ");
                    continue loop;
                }
                else if(cards[cp] < key) fp = cp + 1;
                else if(cards[cp] > key) bp = cp - 1;
            }
            bw.write(String.valueOf(0) + " ");
        }
       
        bw.flush();
        bw.close();
    }    
}