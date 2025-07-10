import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];

        int index = 1;
        int counter = 0;

        while (!isEqualTo(M, numbers)) {
            numbers[index]++;
            counter++;

            if (numbers[index] % 2 == 1) {
                index = (index + L) % N;
            } else {
                index = (index + N - L) % N;
            }
        }

        System.out.println(counter - 1);
    }

    public static boolean isEqualTo(int M, int[] numbers) {
        for(int i=1; i<numbers.length; i++) {
            if (numbers[i] >= M) {
                return true;
            }
        }
        return false;
    }
}