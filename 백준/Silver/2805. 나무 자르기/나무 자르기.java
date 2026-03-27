
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] numbers = new long[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        System.out.println(binarySearch(numbers, M));
    }

    public static long binarySearch(long[] nums, long target) {
        long left = 1;
        long right = nums[nums.length - 1];
        long height = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long availableTree = calculateAvailableTree(nums, mid);

            if (availableTree >= target) {
                height = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return height;
    }

    public static long calculateAvailableTree(long[] nums, long height) {
        long availableTree = 0;

        for(long n : nums) {
            availableTree += Math.max(0, n - height);
        }
        return availableTree;
    }
}