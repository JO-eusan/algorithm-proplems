
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[K];
        for(int i=0; i<K; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);
        System.out.println(binarySearch(numbers, N));
    }

    public static long binarySearch(int[] nums, int target) {
        long left = 1;
        long right = nums[nums.length - 1];
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long availableCount = 0;
            for(long n : nums) {
                availableCount += (n / mid);
            }

            if (availableCount < target) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
        return answer;
    }
}