import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] numbers = new int[13];
    private static boolean[] visited = new boolean[13];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String tmp;
        while (!(tmp = br.readLine()).equals("0")) {
            String[] tokens = tmp.split(" ");
            int N = Integer.parseInt(tokens[0]);

            for(int i=1; i<=N; i++) {
                numbers[i-1] = Integer.parseInt(tokens[i]);
            }

            recursivePrint(N, 0, 0, "");
            System.out.println();
        }
    }

    public static void recursivePrint(int N, int M, int prev, String result) {
        if (M == 6) {
            System.out.println(result);
            return;
        }

        for(int i=prev; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (result.equals("")) {
                    recursivePrint(N, M + 1, i, String.valueOf(numbers[i]));
                } else {
                    recursivePrint(N, M + 1, i, result + " " + String.valueOf(numbers[i]));
                }
                visited[i] = false;
            }
        }
    }
}