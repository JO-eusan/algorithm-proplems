import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[][] arr = new String[N][2];
		
		for(int i = 0; i < N; i++) 
        {
            String[] tmp = br.readLine().split(" ");
            arr[i][0] = tmp[0]; // 나이
            arr[i][1] = tmp[1]; // 이름
        }
        
		Arrays.sort(arr, (e1, e2) -> Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]));
		
		for(int i=0; i<N; i++) 
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");

        bw.flush();
        bw.close();
	}
}