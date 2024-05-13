import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        int result = N-1;

        for(int i=1; i<N; i++)
        {
            if(String.valueOf(i).contains("50"))
                result++;
        }

        bw.write(String.valueOf(result + 1));
        
        bw.flush();
        bw.close();

    }    
}