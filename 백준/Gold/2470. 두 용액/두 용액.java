
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] numbers = new long[N];

        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int answerLeft = 0;
        int answerRight = 0;
        long answer = Long.MAX_VALUE;

        int left = 0;
        int right = N - 1;

        while (left < right) {
            long sum = numbers[left] + numbers[right];

            if (Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                answerLeft = left;
                answerRight = right;
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(numbers[answerLeft] + " " + numbers[answerRight]);
    }
}