import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        System.out.print(factorial(N)/factorial(N-K)/factorial(K));
        
        scanner.close();
    }    

    static int factorial(int n)
    {
        int factorial = 1;

        for(int i=1; i<=n; i++)
            factorial *= i;

        return factorial;
    }
}