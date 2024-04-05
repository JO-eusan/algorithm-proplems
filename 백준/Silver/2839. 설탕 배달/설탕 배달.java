import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int minCount = N;
        for(int i=0; i<=N; i+=5)
        {
            for(int j=0; j<=N; j+=3)
            {
                if(i + j == N)
                {
                    int count = i/5 + j/3;
                    if(minCount > count)
                        minCount = count;
                }
            }
        }

        if(minCount == N)
            System.out.print(-1);
        else
            System.out.print(minCount);
        
        scanner.close();
    }    
}