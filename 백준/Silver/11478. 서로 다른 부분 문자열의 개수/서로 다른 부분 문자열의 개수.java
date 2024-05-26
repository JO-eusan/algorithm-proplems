import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        HashSet<String> result = new HashSet<>();
        String original = br.readLine();

        for(int i=1; i<=original.length(); i++) {
            for(int j=0; j<=original.length()-i; j++) {
                String str = original.substring(j, j+i);

                if(!result.contains(str))
                    result.add(str);
            }
        }

        bw.write(String.valueOf(result.size()));

        bw.flush();
        bw.close();
    }
}