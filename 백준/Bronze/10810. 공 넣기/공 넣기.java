import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 1~N번의 바구니
        int M = scanner.nextInt(); // 공을 넣는 경우의 수

        int[] ball = new int[N];

        for(int t=0; t<M; t++)
        {
            int i = scanner.nextInt(); // i번 부터
            int j = scanner.nextInt(); // j번 까지
            int k = scanner.nextInt(); // k번 공 넣기

            for(int start=i; start<=j; start++)
            {
                ball[start-1] = k;
            }
        }

        for(int t=0; t<N; t++)
        {
            System.out.printf("%d ",ball[t]);
        }

        scanner.close();
    }
}