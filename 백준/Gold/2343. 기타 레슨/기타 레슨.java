
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            total += lectures[i];
        }

        System.out.println(binarySearch(lectures, total, M));
    }

    public static int binarySearch(int[] lectures, int total, int M) {
        int left = lectures[0];
        int right = total;
        int minSize = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isAvailable(lectures, mid, M)) {
                minSize = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSize;
    }

    public static boolean isAvailable(int[] lectures, int size, int M) {
        int count = 1;
        int sum = 0;

        for(int l : lectures) {
            if (l > size) {
                return false;
            }
            if (sum + l > size) {
                count++;
                sum = 0;
            }
            sum += l;
        }

        return count <= M;
    }
}