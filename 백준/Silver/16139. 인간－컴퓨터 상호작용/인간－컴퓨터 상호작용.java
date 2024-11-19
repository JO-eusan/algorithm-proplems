import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        for(int n=0; n<N; n++) {
            String[] tmp = br.readLine().split(" ");
            char find_char = tmp[0].charAt(0);
            int i = Integer.parseInt(tmp[1]);
            int j = Integer.parseInt(tmp[2]);

            int sum = 0;
            for(int k=i; k<=j; k++) {
                char current = str.charAt(k);
                if(current == find_char) {
                    sum++;
                }
            }
            bw.write(String.valueOf(sum) + "\n");
        }

        bw.flush();
        bw.close();
    }
}