import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private static HashMap<String, int[]> results = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for(int n=0; n<N; n++) {
            String[] tokens = br.readLine().split(" ");
            results.put(tokens[0], new int[] {Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])});
        }

        int numberOfCase = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                for(int k=1; k<=9; k++) {
                    if (i == j || j == k || i == k) continue;
                    if (isCase(i, j, k)) {
                        numberOfCase++;
                    }
                }
            }
        }

        System.out.println(numberOfCase);
    }

    public static boolean isCase(int i, int j, int k) {
        for(String number : results.keySet()) {
            int[] tmps = results.get(number);

            int strike = 0;
            int ball = 0;

            if (number.charAt(0) == (i + '0')) {
                strike++;
            } else if (number.contains(String.valueOf(i))) {
                ball++;
            }

            if (number.charAt(1) == (j + '0')) {
              strike++;
            } else if (number.contains(String.valueOf(j))) {
                ball++;
            }

            if (number.charAt(2) == (k + '0')) {
              strike++;
            } else if (number.contains(String.valueOf(k))) {
                ball++;
            }

            if (strike != tmps[0] | ball != tmps[1]) {
                return false;
            }
        }
        return true;
    }
}