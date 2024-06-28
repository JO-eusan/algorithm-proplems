import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> words = new HashSet<>();
		
		for(int i = 0; i < N; i++) 
            words.add(br.readLine());
		
        String[] new_words = words.toArray(new String[0]);
        
		Arrays.sort(new_words, (e1, e2) -> {
			if(e1.length() == e2.length()) {
				return e1.compareTo(e2);
			} else {
				return e1.length() - e2.length();
			}
		});
		
		for(int i=0; i<new_words.length; i++) 
            bw.write(new_words[i] + "\n");

        bw.flush();
        bw.close();
	}
}