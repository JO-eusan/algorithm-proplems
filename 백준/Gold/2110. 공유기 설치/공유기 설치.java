
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] houses = new long[N];
        for(int i=0; i<N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        // 2개의 인접한 집의 최소 거리 D를 찾기
        long left = 1;
        long right = houses[N-1] - houses[0];
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 후보 거리 D

            if (canInstall(houses, mid, C)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canInstall(long[] houses, long D, int C) {
        int count = 1; // 첫 집은 설치되어있다고 가정
        long lastInstalled = houses[0];

        for(int i=1; i<houses.length; i++) {
            if (houses[i] - lastInstalled >= D) {
                count++;
                lastInstalled = houses[i];
            }
        }
        
        return count >= C;
    }
}