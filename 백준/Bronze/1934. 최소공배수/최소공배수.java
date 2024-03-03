import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int t=0; t<T; t++)
        {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int min = A;
            if(min > B)
                min = B;

            int max = 1;
            for(int i=2; i<=min; i++)
            {
                if(A%i==0 && B%i==0)
                    max = i;
            }

            int result = max*(A/max)*(B/max);
            System.out.println(result);
            
        }

        scanner.close();
    }    
}