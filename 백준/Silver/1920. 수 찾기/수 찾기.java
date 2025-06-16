import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] numberN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numberN = new int[N];

        String[] tmps = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            numberN[i] = Integer.parseInt(tmps[i]);
        }

        Arrays.sort(numberN);

        int M = Integer.parseInt(br.readLine());
        for(String tmp : br.readLine().split(" ")) {
            int numberM = Integer.parseInt(tmp);

            System.out.println(searchNumber(0, N - 1, numberM));
        }
    }

    public static int searchNumber(int start, int end, int target) {
        if (start > end) {
            return 0;
        }

        int pivot = (start + end) / 2;

        if (numberN[pivot] == target) {
            return 1;
        } else if (numberN[pivot] < target) {
            return searchNumber(pivot + 1, end, target);
        } else {
            return searchNumber(start, pivot - 1, target);
        }
    }
}