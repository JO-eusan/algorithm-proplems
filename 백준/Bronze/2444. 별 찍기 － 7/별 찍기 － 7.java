import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        // 0번째 행~
        for(int i=0; i<N-1; i++)
        {
            for(int j=0; j<N-(i+1); j++)
                System.out.print(" ");
            for(int j=0; j<2*(i+1)-1; j++)
                System.out.print("*");

            System.out.println();
        }

        // N+1째 행~
        for(int i=N-1; i>=0; i--)
        {
            for(int j=0; j<N-(i+1); j++)
                System.out.print(" ");
            for(int j=0; j<2*(i+1)-1; j++)
                System.out.print("*");
            
            System.out.println();
        }

        scanner.close();
    }
}