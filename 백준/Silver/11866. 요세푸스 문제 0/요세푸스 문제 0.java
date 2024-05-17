import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);

        int[] queue = new int[N*K];
        int[] result = new int[N]; int point = 0;
        for(int i=0; i<N; i++)
            queue[i] = (i+1);
        
        int front = 0; int rear = N-1;

        for(int i=0; i<N-1; i++)
        {
            for(int j=0; j<K-1; j++)
                queue[++rear] = queue[front++];
            
            result[point++] = queue[front++];
        }
        result[point] = queue[front];

        bw.write("<" + result[0]);
        for(int i=1; i<N; i++)
            bw.write(", " + result[i]);
        bw.write(">");
        

        bw.flush();
        bw.close();
    }
}