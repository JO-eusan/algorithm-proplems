import java.io.*;


class Main 
{

    static int[][] combin = new int[31][31];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        combination();

        for(int i=0; i<T; i++)
        {
            String[] tmp = br.readLine().split(" ");

            int r = Integer.parseInt(tmp[0]);
            int n = Integer.parseInt(tmp[1]);
            
            bw.write(String.valueOf(combin[n][r] + "\n"));

        }
        
        bw.flush();
        bw.close();
    }    

    static void combination()
    {
        for(int i=1; i<=30; i++)
            combin[i][1] = i;
        
        for(int i=2; i<=30; i++)
        {
            for(int j=2; j<=30; j++)
                combin[i][j] = combin[i-1][j-1] + combin[i-1][j];
        }
    }
}