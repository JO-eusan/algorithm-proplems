
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = (Y * 100) / X;
        System.out.println(binarySearch(X, Y, Z));
    }

    public static long binarySearch(long X, long Y, long Z) {
        if (Z >= 99) {
            return -1;
        }

        long left = 1;
        long right = 1_000_000_000;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newScore = ((Y + mid) * 100) / (X + mid);

            if (newScore > Z) {
                right = mid -1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}