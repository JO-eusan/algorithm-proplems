import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[2000000];
        int front = -1; int back = -1;
        
        for(int i=0; i<N; i++)
        {
            String[] str = br.readLine().split(" ");
            String cmd = str[0];

            if(cmd.equals("push"))
            {
                int X = Integer.parseInt(str[1]);
                queue[++back] = X;
            }
            else if(cmd.equals("pop"))
            {
                if(front == back)
                    bw.write(String.valueOf(-1) + "\n");
                else
                    bw.write(String.valueOf(queue[++front]) + "\n");
            }
            else if(cmd.equals("size"))
            {
                bw.write(String.valueOf(back-front) + "\n");
            }
            else if(cmd.equals("empty"))
            {
                if(front == back)
                    bw.write(String.valueOf(1) + "\n");
                else
                    bw.write(String.valueOf(0) + "\n");
            }
            else if(cmd.equals("front"))
            {
                if(front == back)
                    bw.write(String.valueOf(-1) + "\n");
                else
                {
                    bw.write(String.valueOf(queue[++front]) + "\n");
                    front--;
                }
            }
            else if(cmd.equals("back"))
            {
                if(front == back)
                    bw.write(String.valueOf(-1) + "\n");
                else
                    bw.write(String.valueOf(queue[back]) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }    
}