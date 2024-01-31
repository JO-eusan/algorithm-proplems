import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
    
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] basket = new int[N]; // N개의 바구니를 배열로 생성

        for(int i=0; i<N; i++)
        {
            basket[i] = (i+1);
        }

        for(int k=0; k<M; k++) // 입력을 M번 받아서 switch
        {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            int chance = (j-i+1) / 2; // 교환할 횟수

            for(int t=i; t<i+chance; t++)
            {
                int tmp = basket[t-1];
                basket[t-1] = basket[j-1];
                basket[j-1] = tmp;
                j--;
            }
        }

        for(int i=0; i<N; i++)
        {
            System.out.printf("%d ", basket[i]);
        }

        scanner.close();
    }
}