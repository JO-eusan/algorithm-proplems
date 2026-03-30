
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int bag5kg = N / 5;

        while (bag5kg != 0) {
            if ((N - 5 * bag5kg) % 3 == 0) {
                break;
            } else {
                bag5kg--;
            }
        }

        int need = N - 5 * bag5kg;
        if (need % 3 == 0) {
            System.out.println(bag5kg + need / 3);
        } else {
            System.out.println(-1);
        }
    }
}