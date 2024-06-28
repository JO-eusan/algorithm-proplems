import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");

		int[] arr = new int[N];
        int[] sorted_arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
            sorted_arr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(sorted_arr);

        HashMap<Integer, Integer> funct = new HashMap<>();

        int n = 0; int idx = 0;
        while(idx != N) {
            if(!funct.containsKey(sorted_arr[idx])) {
                funct.put(sorted_arr[idx], n);
                n++;
            }
            idx++;
        }
            
        for(int i=0; i<N; i++)
            bw.write(String.format("%d ", funct.get(arr[i])));
        

        bw.flush();
        bw.close();
	}
}