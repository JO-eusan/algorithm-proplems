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
            for(int j=0; j<N; j++)
            {
                if(i != j)
                    count++;
            }
        }

        System.out.print(count);
        
        scanner.close();
    }    
}