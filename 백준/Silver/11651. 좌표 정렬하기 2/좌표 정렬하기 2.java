import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(arr, (e1, e2) -> {
			if(e1[1] == e2[1]) {
				return e1[0] - e2[0];
			} else {
				return e1[1] - e2[1];
			}
		});
		
		for(int i=0; i<N; i++) 
            bw.write(String.format("%d %d\n", arr[i][0], arr[i][1]));

        bw.flush();
        bw.close();
	}
}