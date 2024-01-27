import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int[] A = new int[N]; 

        for(int i=0; i<N; i++)
        {
            A[i] = scanner.nextInt();
        }

        for(int i=0; i<N; i++)
        {
            if(A[i] < X)
                System.out.printf("%d ", A[i]);
        }
        

        scanner.close();
    }    
}