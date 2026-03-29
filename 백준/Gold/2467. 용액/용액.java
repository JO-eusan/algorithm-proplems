
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] minPair = search(nums);

        System.out.println(minPair[0] + " " + minPair[1]);
    }

    public static int[] search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int minValue = Integer.MAX_VALUE;
        int[] minPair = new int[2];

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (Math.abs(sum) < minValue) {
                minValue = Math.abs(sum);
                minPair[0] = nums[left];
                minPair[1] = nums[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                return minPair;
            }
        }
        return minPair;
    }
}