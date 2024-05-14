import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[N];
        for(int i=0; i<N; i++)
            queue[i] = i+1;
        int front = 0; int back = N-1;
        
        while(front != back)
        {
            front += 2;
            front %= N;
            back += 1;
            back %= N;
            queue[back] = queue[(front + (N-1)) % N];
        }
        bw.write(String.valueOf(queue[front]));

        bw.flush();
        bw.close();
    }    
}