import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String tmp = br.readLine();

        String[] stack_1 = new String[N];
        String[] stack_2 = new String[N];
        for(int i=0; i<N; i++)
        {
            stack_1[i] = tmp.split(" ")[N-1-i];
        }

        int top_1 = N-1, top_2 = -1;

        counting: for(int i=1; i<=N; i++)
        {
            if(top_1 >= 0 && Integer.parseInt(stack_1[top_1]) == i)
            {
                top_1--;
                continue counting;
            }
            else if(top_2 >= 0 && Integer.parseInt(stack_2[top_2]) == i)
            {
                top_2--;
                continue counting;
            }
            else
            {
                // stack 1 검사
                for(int j=0; j<top_1; j++)
                {
                    if(Integer.parseInt(stack_1[j]) == i)
                    {
                        for(int k=top_1; k>j; k--)
                        {
                            stack_2[++top_2] = stack_1[k];
                            top_1--;
                        }
                        top_1--;
                        continue counting;
                    }
                }
            }
        }
        
        if(top_1 == -1 && top_2 == -1)
            bw.write("Nice");
        else
            bw.write("Sad");

        bw.flush();
        bw.close();

    }    
}