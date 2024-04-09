import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        while(str.charAt(0) != '.')
        {
            char[] stacks = new char[100];
            int point = -1; // empty stacks

            for(int i=0; i<str.length(); i++)
            {
                if(str.charAt(i) == '(' || str.charAt(i) == '[')
                    stacks[++point] = str.charAt(i);
                else if((str.charAt(i) == ')' || str.charAt(i) == ']'))
                {
                    if(point > -1 && str.charAt(i) == ')' && stacks[point] == '(')
                        point--;
                    else if(point > -1 && str.charAt(i) == ']' && stacks[point] == '[')
                        point--;
                    else
                        stacks[++point] = str.charAt(i);
                }
            }

            if(point == -1)
                bw.write("yes\n");
            else
            bw.write("no\n");

            str = br.readLine();
        }
        
        bw.flush();
        bw.close();
    }
}