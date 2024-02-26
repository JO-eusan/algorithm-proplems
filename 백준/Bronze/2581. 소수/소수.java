import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int count = 0; // 1일때만 min의 값을 update
        int sum = 0;
        int min = 0;
        for(int i=M; i<=N; i++)
        {   
            // 소수 확인
            if(i == 2)
            {
                count++;
                sum += i;
            }
            else
            {
                for(int t=2; t<i; t++)
                {
                    if(i%t == 0)
                        break;
                    if(t == (i-1))
                    {
                        count++;
                        sum += i;
                    }
                }
            }

            // 최솟값 update
            if(count == 1)
                min = sum;
        }

        if(count == 0)
            System.out.print(-1);
        else
        {
            System.out.println(sum);
            System.out.println(min);
        }
        
        scanner.close();
    }    
}