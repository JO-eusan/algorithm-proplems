
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

        int[] lis = new int[N]; // 원소의 위치를 저장할 배열
        int size = 0;

        for(int num : nums) { // 각 원소별 위치를 찾음
            int left = 0;
            int right = size;

            while (left < right) {
                int mid = (left + right) / 2;

                if (lis[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            lis[left] = num;
            if (left == size) {
                size++;
            }
        }

        System.out.println(size);
    }
}