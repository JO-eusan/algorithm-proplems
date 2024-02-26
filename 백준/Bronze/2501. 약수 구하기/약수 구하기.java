import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // N의 약수 중
        int K = scanner.nextInt(); // K번째로 작은 수

        int count = 0;
        for(int i=1; i<=N; i++)
        {
            if(N%i == 0)
                count++;

            if(count == K)
            {
                System.out.print(i);
                break;
            }
        }

        if(K > count)
            System.out.print(0);
        
        scanner.close();
    }    
}