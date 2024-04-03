import java.util.*;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] cards = new int[N];
        for(int i=0; i<N; i++)
            cards[i] = scanner.nextInt();
        
        int max = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                for(int k=j+1; k<N; k++)
                {
                    if((cards[i] + cards[j] + cards[k]) <= M && (cards[i] + cards[j] + cards[k]) > max)
                        max = cards[i] + cards[j] + cards[k];
                }
            }
        }

        System.out.print(max);

        scanner.close();
    }    
}
