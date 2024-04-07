import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        int[] stacks = new int[K];
        int point = -1; // empty stack

        for(int i=0; i<K; i++)
        {
            int tmp = Integer.parseInt(br.readLine());

            if(tmp == 0)
                point--;
            else
                stacks[++point] = tmp;
        }

        int sum = 0;
        for(int i=0; i<=point; i++)
            sum += stacks[i];

        bw.write(sum + "\n");

        bw.flush();
        bw.close();

    }    
}