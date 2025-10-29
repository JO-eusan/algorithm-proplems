import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] numbers = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<5; i++) {
            sum += Math.pow(numbers[i], 2);
        }
        System.out.println(sum % 10);
    }   
}