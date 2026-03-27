
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long M = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);
        System.out.println(binarySearch(numbers, M));
    }

    public static long binarySearch(long[] nums, long total) {
        long left = 0;
        long right = nums[nums.length - 1];
        long maxCount = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isAvailable(nums, total, mid)) {
                maxCount = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxCount;
    }

    public static boolean isAvailable(long[] nums, long total, long upperBound) {
        int count = 0;
        for(long n : nums) {
            count += Math.min(n, upperBound);
        }
        return count <= total;
    }
}