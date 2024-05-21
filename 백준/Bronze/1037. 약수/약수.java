import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num_f = Integer.parseInt(br.readLine());
        int[] factors = new int[num_f];

        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<num_f; i++)
            factors[i] = Integer.parseInt(tmp[i]);
        
        int min = factors[0], max = factors[0];
        for(int i=1; i<num_f; i++)
        {
            if(factors[i] > max)
                max = factors[i];
            if(factors[i] < min)
                min = factors[i];
        }

        bw.write(String.valueOf(max*min));

        bw.flush();
        bw.close();
    }    
}