import java.util.Scanner;

public class Main {

    private static final int EUREKA_NUM = 3;
    private static int[] gauss;
    private static boolean check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        gauss = new int[51];

        /* 가우스 식 결과 저장 */
        for(int i=1; i < gauss.length; i++) {
            gauss[i] = i * (i + 1) / 2;
        }

        int T = Integer.parseInt(scanner.nextLine());
        for(int i=0; i < T; i++) {
            int K = Integer.parseInt(scanner.nextLine());
            check = false;

            /* K에 대한 DFS */
            eureka(K, 0, 0);
            System.out.println(check ? 1 : 0);
        }

        scanner.close();
    }

    private static void eureka(int K, int depth, int sum) {
        if (check) { return; }
        if (depth == EUREKA_NUM) {
            if (K == sum) {
                check = true;
            }
            return;
        }
        
        for(int i=1; i<gauss.length; i++) {
            eureka(K, depth + 1, sum + gauss[i]);
        }
    }
}