import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        long min = A;
        if(min>B)
            min = B;

        long max_factor = 1;
        for(long i=2; i<=min; i++)
        {
            if(A%i==0 && B%i==0)
                max_factor = i;
        }
        
        long result = max_factor*(A/max_factor)*(B/max_factor);
        System.out.print(result);

        scanner.close();
    }    
}