import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> cards = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String[] card_nums = br.readLine().split(" ");
        for(int i=0; i<N; i++)
        {
            if(cards.containsKey(card_nums[i]))
                cards.replace(card_nums[i], cards.get(card_nums[i]) + 1);
            else
                cards.put(card_nums[i], 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        String[] output = br.readLine().split(" ");
        for(int i=0; i<M; i++)
        {
            if(cards.get(output[i]) != null)
                bw.write(String.valueOf(cards.get(output[i])) + " ");
            else
                bw.write(String.valueOf(0) + " ");
        }
        

        bw.flush();
        bw.close();
    }
}