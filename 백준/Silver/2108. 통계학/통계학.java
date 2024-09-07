import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 산술평균
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += numbers[i];
        }
        bw.write(Math.round((double)sum / N) + "\n");

        // 중앙값
        Arrays.sort(numbers);
        bw.write(numbers[N / 2] + "\n");

        // 최빈값
        int range = numbers[N-1] - numbers[0];
        int[] count = new int[range + 1]; // 최소값 ~ 최대값 index
    
        for(int i=0; i<N; i++) {
            count[numbers[i] - numbers[0]]++;
        }

        int mod = 0;
        for(int i=0; i<count.length; i++) {
            if(count[mod] < count[i]) 
                mod = i;
        }

        for(int i=0; i<count.length; i++) {
            if(i != mod && count[mod] == count[i]) {
                mod = i;
                break;
            }
        }

        mod += numbers[0];
        bw.write(mod + "\n");

        // 범위
        bw.write(range + "\n");

        bw.flush();
        bw.close();
    }
}