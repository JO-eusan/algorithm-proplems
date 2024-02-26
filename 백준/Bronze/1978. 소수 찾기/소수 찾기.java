import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int count = 0;

        for(int i=0; i<N; i++)
        {
            int number = scanner.nextInt();

            // 소수 검증
            if(number == 2)
                count++;
            else
            {
                for(int t=2; t<number; t++)
                {
                    if(number%t == 0)
                        break;
                    if(t == (number-1))
                        count++; 
                }
            }
        }

        System.out.print(count);
        
        scanner.close();
    }    
}