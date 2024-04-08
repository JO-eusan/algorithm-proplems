import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++)
        {
            char[] stacks = new char[50];
            int point = -1; // empty stack

            String vps = br.readLine();
            for(int i=0; i<vps.length(); i++)
            {
                if(vps.charAt(i) == '(')
                    stacks[++point] = '('; // push
                else if(vps.charAt(i) == ')')
                {
                    if(point >= 0 && stacks[point] == '(')
                        point--; // pop
                    else
                        stacks[++point] = ')'; // not correct
                }
            }

            if(point == -1)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }
}