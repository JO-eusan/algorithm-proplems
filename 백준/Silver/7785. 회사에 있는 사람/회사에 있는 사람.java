import java.io.*;
import java.util.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> names = new HashSet<>();

        for(int i=0; i<n; i++)
        {
            String[] input = br.readLine().split(" ");

            if(names.contains(input[0]))
                names.remove(input[0]);
            else
                names.add(input[0]);
        }
        
        String[] result = new String[names.size()];
        names.toArray(result);
        Arrays.sort(result);

        for(int i=names.size()-1; i >= 0; i--)
            bw.write(result[i] + "\n");
        
        bw.flush();
        bw.close();
    }
}