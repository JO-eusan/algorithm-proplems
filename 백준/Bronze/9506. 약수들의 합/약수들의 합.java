import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            int n = scanner.nextInt();
            if(n == -1) // EOF
                break;
            
            int sum = 0;
            for(int i=1; i<n; i++) // perfect 검증
            {
                if(n%i == 0)
                    sum += i;
            }

            // 출력
            if(n == sum)
            {
                System.out.printf("%d = 1 ", n);
                for(int i=2; i<n; i++)
                {
                    if(n%i == 0)
                        System.out.printf("+ %d ", i);
                }
                System.out.println();
            }
            else
                System.out.printf("%d is NOT perfect.\n", n);
        }
        
        scanner.close();
    }    
}