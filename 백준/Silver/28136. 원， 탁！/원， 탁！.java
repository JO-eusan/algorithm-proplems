import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] tmp_numbers = br.readLine().split(" ");
        int[] numbers = new int[N];
        for(int i=0; i<N; i++)
            numbers[i] = Integer.parseInt(tmp_numbers[i]);
        
        int count=0;
        for(int i=0; i<N; i++)
        {
            if(numbers[i%N] >= numbers[(i+1)%N])
                count++;
        }
        bw.write("" + count);

        bw.flush();
        bw.close();
    }    
}