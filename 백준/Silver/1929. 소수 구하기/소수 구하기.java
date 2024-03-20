import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        MNloop : for(int n=M; n<=N; n++)
        {
            for(int k=2; k<=Math.sqrt(n); k++)
            {
                if(n%k == 0)
                    continue MNloop;
            }

            if( n != 1)
                System.out.println(n);
        }
        scanner.close();
    }    
}