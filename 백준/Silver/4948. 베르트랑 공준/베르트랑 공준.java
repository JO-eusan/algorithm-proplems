import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            int n = scanner.nextInt();
            if(n == 0)
                break;
            
            int result = 0;
            bereterang : for(int t=n+1; t<=2*n; t++)
            {
                for(int k=2; k<=Math.sqrt(t); k++)
                {
                    if(t%k == 0)
                        continue bereterang;
                }
    
                if(t != 1)
                    result++;
            }
    
            System.out.println(result);
            
        }

        scanner.close();
    }    
}