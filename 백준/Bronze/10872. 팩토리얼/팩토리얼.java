import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int factorial = 1;

        for(int i=1; i<=N; i++)
            factorial *= i;

        System.out.print(factorial);

        scanner.close();
    }    
}