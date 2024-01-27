import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N]; 

        for(int i=0; i<N; i++)
        {
            A[i] = scanner.nextInt();
        }

        int min = A[0];
        int max = A[0];
        for(int i=1; i<N; i++)
        {
            if(A[i]>max)
                max = A[i];
            else if(A[i] < min)
                min = A[i];
        }
        
        System.out.printf("%d %d", min, max);
        
        scanner.close();
    }    
}