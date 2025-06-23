import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        
        numbers = new int[N];
        String[] secondLine = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(secondLine[i]);
        }

        Arrays.sort(numbers);
        int min = 0;
        int max = numbers[N - 1];

        long maxLength = searchNumber(min, max - 1, M);

        System.out.println(maxLength);
    }

    public static long searchNumber(long start, long end, int target) {
        long pivot = (start + end) / 2;
        long availableTree = calculateAvailableLength(pivot);

        if(availableTree == target || start > end) {
            return pivot;
        } else if (availableTree > target) {
            return searchNumber(pivot + 1, end, target);
        } else { // availableTree < target
            return searchNumber(start, pivot - 1, target);
        }
    }

    private static long calculateAvailableLength(long pivot) {
        long availableTree = 0;

        for(int i=0; i<numbers.length; i++) {
            availableTree += (Math.max(0, numbers[i] - pivot));
        }
        return availableTree;
    }
}