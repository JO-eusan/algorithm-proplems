import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // index 0: R, 1: U, 2: X
        int[] cmd_num = new int[3];
        for(int i=0; i<N; i++)
        {
            if(str.charAt(i) == 'R')
                cmd_num[0]++;
            else if(str.charAt(i) == 'U')
                cmd_num[1]++;
            else if(str.charAt(i) == 'X')
                cmd_num[2]++;
        }

        int K = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<K; i++)
        {
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]) - 1;
            int y = Integer.parseInt(tmp[1]) - 1;

            int min = Math.min(x, y);
            min = Math.min(min, cmd_num[2]);

            if(x-min <= cmd_num[0] && y-min <= cmd_num[1])
                count++;
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }    
}