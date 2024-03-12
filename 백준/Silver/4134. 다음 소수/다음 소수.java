import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int i=0; i<T; i++)
        {
            long n = scanner.nextLong();

            while(true)
            {
                boolean check = true; // 소수라면 true
                for(long j = 2; j<=Math.sqrt(n); j++)
                {
                    if(n%j == 0)
                    {
                        check = false;
                        break;
                    }
                }
                
                if(check == true)
                {
                    if(n==0 || n==1)
                        n=2;
                    System.out.println(n);
                    break;
                }
                n++;
            }

        }

        scanner.close();
    }    
}