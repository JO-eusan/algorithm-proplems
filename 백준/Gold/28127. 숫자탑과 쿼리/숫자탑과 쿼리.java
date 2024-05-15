import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Q = Integer.parseInt(br.readLine());
        for(int q=0; q<Q; q++)
        {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int d = Integer.parseInt(tmp[1]);
            int x = Integer.parseInt(tmp[2]);

            int count = 1;
            int n = 1;
            for(; ; n++)
            {
                if(count + (a + (n-1)*d) - 1 >= x)
                    break;

                count += (a + (n-1)*d);
            }

            bw.write("" + n + " " + (x-count+1) + "\n");
            
        }

        bw.flush();
        bw.close();
    }    
}