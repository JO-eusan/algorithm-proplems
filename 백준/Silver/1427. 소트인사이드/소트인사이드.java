import java.util.*;
import java.io.*;

class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        List<Character> array = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            array.add(str.charAt(i));
        }

        Collections.sort(array, Comparator.reverseOrder());
        for(int i=0; i<str.length(); i++)
            bw.write(array.get(i));

        bw.flush();
        bw.close();
    }
}