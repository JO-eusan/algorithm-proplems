import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_line = br.readLine().split(" ");
        int N = Integer.parseInt(first_line[0]);
        int M = Integer.parseInt(first_line[1]);

        HashSet<String> not_listen = new HashSet<>();
        for(int n=0; n<N; n++)
            not_listen.add(br.readLine());

        List<String> and_not_see = new ArrayList<>();

        for(int m=0; m<M; m++) {
            String name = br.readLine();

            if(not_listen.contains(name))
                and_not_see.add(name);
        }

        Collections.sort(and_not_see);


        bw.write(String.valueOf(and_not_see.size()) + "\n");
        for(int i=0; i<and_not_see.size(); i++)
            bw.write(and_not_see.get(i) + "\n");
        
        bw.flush();
        bw.close();
    }
}