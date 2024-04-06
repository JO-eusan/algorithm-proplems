import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] stack = new int[1000000];
        int point = -1; // empty stack

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            String command = br.readLine();
                
            switch(command.charAt(0))
            {
                case '1':
                    int x = Integer.parseInt(command.split(" ")[1]);
                    stack[++point] = x;
                    break;

                case '2':
                    if(point == -1)
                        bw.write(point + "\n");
                    else
                        bw.write(stack[point--] + "\n");
                    break;

                case '3':
                    bw.write((point+1) + "\n");
                    break;

                case '4':
                    if(point == -1)
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;

                case '5':
                    if(point == -1)
                        bw.write(point + "\n");
                    else
                        bw.write(stack[point] + "\n");
                    break;

            }
        }
        
        bw.flush();
        bw.close();
    }    
}