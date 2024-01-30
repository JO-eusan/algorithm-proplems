import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 1~N번의 바구니
        int M = scanner.nextInt(); // shuffle 횟수

        int[] ball = new int[N];

        // 번호 적힌 공 넣기
        for(int i=0; i<N; i++)
        {
            ball[i] = i+1;
        }

        for(int k=0; k<M; k++)
        {
            int i = scanner.nextInt();
            int j = scanner.nextInt(); 
            
            int tmp = ball[i-1];
            ball[i-1] = ball[j-1];
            ball[j-1] = tmp;
        }

        for(int i=0; i<N; i++)
        {
            System.out.printf("%d ",ball[i]);
        }

        scanner.close();
    }
}